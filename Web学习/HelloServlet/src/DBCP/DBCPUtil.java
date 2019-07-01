package DBCP;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mysql.jdbc.ResultSet;




public class DBCPUtil {
	private static DataSource ds = null;//数据源，也就是连接池
	
	static {
		Properties prop = new Properties();
		
		try {
			//根据DBCPUtil的class路径加载配置文件
			prop.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbinfo2.properties"));
			ds = BasicDataSourceFactory.createDataSource(prop);//得到一个数据源（连接池）
			
			
		}catch (Exception e) {
			throw new ExceptionInInitializerError("初始化错误，请检查配置文件");
		}
		
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("服务器忙。。。。");
		}
	}
	
	public static void release(Connection conn,Statement stmt,ResultSet rs) {
		//关闭资源
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
				conn.close();//关闭就是将连接放回去
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
