package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

public class TestJDBC {

	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		DataSource ds = new MyDataSource();
		try {
			conn = ds.getConnection();//从池中取出一个连接MyConnection
			ps = conn.prepareStatement("...");
			
			
			//.....
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();//此时关闭调用的是自己写的类，关闭操作时将连接放到连接池的最后一个
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
