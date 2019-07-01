package util;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TestCRUD_2 {

	//插入
	@Test
	public void testInsert() throws SQLException {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("insert into users(username,password,email,birthday) values(?,?,?,?)","tom","123","aaa@163.com","2018/10/10");
	}
	
	//修改
	@Test
	public void testUpdate() throws SQLException {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("update users set password=? where username=?","123","111");
	}
	
	//删除
	@Test
	public void testDelete() throws SQLException {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("delete from users where username=?","111");
	}
	
	
	@Test //批处理，只能执行相同的sql语句
	public void testBatch() throws SQLException {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		Object[][] params = new Object[10][];//高维代表执行多少次sql语句
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] {"cat"+i,"456","bbc@163.com","2018/10/12"};//给每次执行的sql语句中的？赋值
		}
		
		qr.batch("insert into users(username,password,email,birthday) values(?,?,?,?)",params);
	}
	
	
	
}
