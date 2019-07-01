package DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.Test;

public class TestJDBC {

	@Test
	public void Tes1() {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBCPUtil.getConnection();
			ps = conn.prepareStatement("sql...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBCPUtil.release(conn, ps, null);
		}
		
	}
}
