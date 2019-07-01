package ZhuanZhang_2;

import java.sql.Connection;
import java.sql.SQLException;

import util.C3P0Util;

public class ManagerThreadLocal {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	//得到一个连接
	public static Connection getConnection() {
		Connection conn = tl.get();//从当前线程中取出一个连接
		if(conn==null) {//如果从线程中没有取到，那么就去线程池中取
			conn = C3P0Util.getConnection();//从池中取出一个连接
			tl.set(conn);//把conn对象放入线程中
		}
		return conn;
	}
	
	
	public static void startTransacation() {
		try {
			Connection conn =getConnection();
			conn.setAutoCommit(false);//从当前对象中取出的连接，并开启事务
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void commit() {
		try {
			getConnection().commit();//提交事务
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void rollback() {
		try {
			getConnection().rollback();//回滚事务
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			getConnection().close();//将连接放回池中
			tl.remove();//把当前线程对象中的conn移除
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
