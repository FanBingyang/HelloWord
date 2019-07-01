package DBCP;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mysql.jdbc.ResultSet;




public class DBCPUtil {
	private static DataSource ds = null;//����Դ��Ҳ�������ӳ�
	
	static {
		Properties prop = new Properties();
		
		try {
			//����DBCPUtil��class·�����������ļ�
			prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbinfo2.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop);//�õ�һ������Դ�����ӳأ�
			
			
		}catch (Exception e) {
			throw new ExceptionInInitializerError("��ʼ���������������ļ�");
		}
		
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("������æ��������");
		}
	}
	
	public static void release(Connection conn,Statement stmt,ResultSet rs) {
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
				conn.close();//�رվ��ǽ����ӷŻ�ȥ
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
