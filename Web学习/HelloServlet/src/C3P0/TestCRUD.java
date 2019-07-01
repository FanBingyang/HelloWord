package C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

public class TestCRUD {
	
	@Test
	public void test1() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = C3P0Util.getConnection();
			ps = conn.prepareStatement("insert into zhanghu(name,money) values('ccc',2000)");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			C3P0Util.release(null, ps, conn);
		}
		
		System.out.println(conn.getClass().getName());
	}
}
