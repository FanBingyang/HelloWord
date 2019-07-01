package util;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TestCRUD_2 {

	//����
	@Test
	public void testInsert() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("insert into users(username,password,email,birthday) values(?,?,?,?)","tom","123","aaa@163.com","2018/10/10");
	}
	
	//�޸�
	@Test
	public void testUpdate() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("update users set password=? where username=?","123","111");
	}
	
	//ɾ��
	@Test
	public void testDelete() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		qr.update("delete from users where username=?","111");
	}
	
	
	@Test //������ֻ��ִ����ͬ��sql���
	public void testBatch() throws SQLException {
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

		Object[][] params = new Object[10][];//��ά����ִ�ж��ٴ�sql���
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[] {"cat"+i,"456","bbc@163.com","2018/10/12"};//��ÿ��ִ�е�sql����еģ���ֵ
		}
		
		qr.batch("insert into users(username,password,email,birthday) values(?,?,?,?)",params);
	}
	
	
	
}
