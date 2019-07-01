package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

public class TestCRUD {
	
	@Test
	public void testSelect1() throws SQLException {
		//常见一个QueryRunner对象
		QueryRunner qr  =new QueryRunner(C3P0Util.getDataSource());
		List<User> list = qr.query("select * from users", new ResultSetHandler<List<User>>() {
			//当query方法执行select语句后，将结果集以参数的形式传递过来
			public List<User> handle(ResultSet rs) throws SQLException{
				List<User> list = new ArrayList<User>();
				while(rs.next()) {
					User u  =new User();
					u.setUsername(rs.getString(1));
					u.setPassword(rs.getString(2));
					u.setEmail(rs.getString(3));
					u.setBirthday(rs.getString(4));
					list.add(u);
				}
				return list;
			}
		});
		
		for (User user : list) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testSelect2() throws SQLException {
		//常见一个QueryRunner对象
		QueryRunner qr  =new QueryRunner(C3P0Util.getDataSource());
		//执行查询语句，并返回结果
		List<User> list = qr.query("select * from users",new BeanListHandler<User>(User.class));
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	
	@Test
	public void testSelect3() throws SQLException {
		//常见一个QueryRunner对象
		QueryRunner qr  =new QueryRunner(C3P0Util.getDataSource());
		//执行查询语句，并返回结果,
		//如果时where语句，从第三个参数开始，是Object类型的参数，也就是对应前面的？，有几个查询条件后面就要按照顺序写对应的几个参数
		List<User> list = qr.query("select * from users where username=?",new BeanListHandler<User>(User.class),"aaa");
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}

