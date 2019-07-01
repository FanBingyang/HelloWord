package ZhuanZhang_2;

import java.sql.Connection;
import java.sql.SQLException;

import util.C3P0Util;

public class ManagerThreadLocal {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//�õ�һ������
	public static Connection getConnection() {
		Connection conn = tl.get();//�ӵ�ǰ�߳���ȡ��һ������
		if(conn==null) {//������߳���û��ȡ������ô��ȥ�̳߳���ȡ
			conn = C3P0Util.getConnection();//�ӳ���ȡ��һ������
			tl.set(conn);//��conn��������߳���
		}
		return conn;
	}
	
	
	public static void startTransacation() {
		try {
			Connection conn =getConnection();
			conn.setAutoCommit(false);//�ӵ�ǰ������ȡ�������ӣ�����������
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void commit() {
		try {
			getConnection().commit();//�ύ����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void rollback() {
		try {
			getConnection().rollback();//�ع�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			getConnection().close();//�����ӷŻس���
			tl.remove();//�ѵ�ǰ�̶߳����е�conn�Ƴ�
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
