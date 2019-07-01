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

	@Test //ArrayHandler:�ʺ�ȡ1�����ݼ�¼���Ѹü�¼��ÿ��ֵ����װ��һ��������Object[]
	public void test1() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object[] arr = qr.query("select * from users where username=?", new ArrayHandler(),"cat1");
		
		for (Object object : arr) {
			System.out.println(object);
		}
		
	}
	
	@Test //ArrayListHandler:�ʺ϶�����¼����ÿ����¼��ÿ��ֵ��װ��һ�������� ��Object[]���������װ��һ��List��
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
	
	@Test //ColumnListHandler:ȡĳһ�е����ݣ���װ��List��
	public void test3() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		//ȡ��sql����ѯ�����ĵڶ���
		List<Object> list = qr.query("select username,password from users", new ColumnListHandler(2));
		
		for (Object objects : list) {
			System.out.println(objects);
		}
		
	}
	
	
	@Test //KeyedHandler:ȡ������¼��ÿһ����¼��װ��һ��Map�У��ٰ����Map��װ����һ��Map�У�keyΪָ�����ֶ�ֵ
	public void test4() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		//��Map��key�Ǳ��е�ĳ�����ݣ�СMap�е�key�Ǳ�����������Դ�Map��key��Object���ͣ�СMap��key��String����
		Map<Object, Map<String,Object>> map = qr.query("select * from users", new KeyedHandler(1));
		
				
		for (Map.Entry<Object,Map<String,Object>> m : map.entrySet())
		{
			System.out.println(m.getKey());//��Map��Keyֵ����id�е�ֵ
			for (Map.Entry<String, Object> mm : m.getValue().entrySet()) {
				System.out.println(mm.getKey()+"\t"+mm.getValue());
			}
			System.out.println("-------------------------------");
		}
		
	}
	
	
	@Test //MapHandler:�ʺ�ȡ1����¼���ѵ�ǰ��¼����������ֵ�ŵ�һ��Map��
	public void test5() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Map<String, Object> map = qr.query("select * from users", new MapHandler());
		
		for (Map.Entry<String, Object> m : map.entrySet()) {
			System.out.println(m.getKey()+"\t"+m.getValue());
		}
		
	}
	
	
	@Test //MapListHandler:�ʺ�ȡ������¼����ÿ����¼��װ��һ��Map�У��ٰ�Map��װ��List��
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
	
	
	@Test //ScalarHandler:�ʺ�ȡ���е��е�����
	public void test7() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object o = qr.query("select count(*) from users", new ScalarHandler(1));
		
		System.out.println(o);
	}
	
	
	@Test //BeanHandler:�ʺ�ȡ���е��е�����
	public void test8() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		User u = qr.query("select * from users where username=?", new BeanHandler<User>(User.class),"aaa");
		
		System.out.println(u);
	}
	
	@Test //BeanListHandler:�ʺ�ȡ���е��е�����
	public void test9() throws SQLException {
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		List<User> list= qr.query("select * from users where username=?", new BeanListHandler<User>(User.class),"aaa");
		
		System.out.println(list.size());//������0
	}
	
	
}
