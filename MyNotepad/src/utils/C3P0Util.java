package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//�õ�һ������Դ
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//��������Դ
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	
	
	//������Դ�еõ�һ�����Ӷ���
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
        } catch (Exception e) {
			throw new RuntimeException("����������");
		}
	}
	
	//�ͷ���Դ
	public static void release(ResultSet rs,Statement stmt,Connection conn){
		//�ر���Դ
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
}
