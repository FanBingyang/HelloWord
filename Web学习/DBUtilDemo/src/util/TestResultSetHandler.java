package util;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

public class TestResultSetHandler {

	@Test //ArrayHandler:适合取1条数据记录，把该记录的每列值都封装到一个数组中Object[]
	public void test1() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object[] arr = qr.query("select * from users where username=?", new ArrayHandler(),"cat1");
		
		for (Object object : arr) {
			System.out.println(object);
		}
		
	}
	
	@Test //ArrayListHandler:适合多条记录，把每条记录的每列值封装到一个数组中 的Object[]，把数组封装到一个List中
	public void test2() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		List<Object[]> query = qr.query("select * from users", new ArrayListHandler());
		
		
		for (Object[] object : query) {
			for (Object ob : object) {
				System.out.println(ob);
			}
			System.out.println("-------------");
		}
	}
	
	@Test //ColumnListHandler:取某一列的数据，封装到List中
	public void test3() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		//取出sql语句查询出来的第二列
		List<Object> list = qr.query("select username,password from users", new ColumnListHandler(2));
		
		for (Object objects : list) {
			System.out.println(objects);
		}
		
	}
	
	
	@Test //KeyedHandler:取多条记录，每一条记录封装到一个Map中，再把这个Map封装到另一个Map中，key为指定的字段值
	public void test4() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		//大Map的key是表中的某列数据，小Map中的key是表的列名，所以大Map的key是Object类型，小Map的key是String类型
		Map<Object, Map<String,Object>> map = qr.query("select * from users", new KeyedHandler(1));
		
				
		for (Map.Entry<Object,Map<String,Object>> m : map.entrySet())
		{
			System.out.println(m.getKey());//大Map中Key值就是id列的值
			for (Map.Entry<String, Object> mm : m.getValue().entrySet()) {
				System.out.println(mm.getKey()+"\t"+mm.getValue());
			}
			System.out.println("-------------------------------");
		}
		
	}
	
	
	@Test //MapHandler:适合取1条记录，把当前记录的列名和列值放到一个Map中
	public void test5() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Map<String, Object> map = qr.query("select * from users", new MapHandler());
		
		for (Map.Entry<String, Object> m : map.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
		
	}
	
	
	@Test //MapListHandler:适合取多条记录，把每条记录封装到一个Map中，再把Map封装到List中
	public void test6() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		List<Map<String, Object>> list = qr.query("select * from users", new MapListHandler());
		
		for (Map<String, Object> map : list) {
			for (Map.Entry<String, Object> m : map.entrySet()) {
				System.out.println(m.getKey()+"\t"+m.getValue());
			}
			System.err.println("------------------------");
		}
		
	}
	
	
	@Test //ScalarHandler:适合取单行单列的数据
	public void test7() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object o = qr.query("select count(*) from users", new ScalarHandler(1));
		
		System.out.println(o);
	}
	
	
	@Test //BeanHandler:适合取单行单列的数据
	public void test8() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		User u = qr.query("select * from users where username=?", new BeanHandler<User>(User.class),"aaa");
		
		System.out.println(u);
	}
	
	@Test //BeanListHandler:适合取单行单列的数据
	public void test9() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<User> list= qr.query("select * from users where username=?", new BeanListHandler<User>(User.class),"aaa");
		
		System.out.println(list.size());//长度是0
	}
	
	
}
