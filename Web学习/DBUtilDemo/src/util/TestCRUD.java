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
		//����һ��QueryRunner����
		QueryRunner qr  =new QueryRunner(C3P0Util.getDataSource());
		List<User> list = qr.query("select * from users", new ResultSetHandler<List<User>>() {
			//��query����ִ��select���󣬽�������Բ�������ʽ���ݹ���
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
		//����һ��QueryRunner����
		QueryRunner qr  =new QueryRunner(C3P0Util.getDataSource());
		//ִ�в�ѯ��䣬�����ؽ��
		List<User> list = qr.query("select * from users",new BeanListHandler<User>(User.class));
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
	
	
	@Test
	public void testSelect3() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr  =new QueryRunner(C3P0Util.getDataSource());
		//ִ�в�ѯ��䣬�����ؽ��,
		//���ʱwhere��䣬�ӵ�����������ʼ����Object���͵Ĳ�����Ҳ���Ƕ�Ӧǰ��ģ����м�����ѯ���������Ҫ����˳��д��Ӧ�ļ�������
		List<User> list = qr.query("select * from users where username=?",new BeanListHandler<User>(User.class),"aaa");
		
		for (User user : list) {
			System.out.println(user);
		}
		
	}
}

