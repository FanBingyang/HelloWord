package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class TestSource {

	private void mian() {
		DataSource ds = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();//实现类：com.mysql.jdbc.Connection
			ps = conn.prepareStatement("...");
			
			//....
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();//不能关，从连接池拿出来就还要放回去
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
