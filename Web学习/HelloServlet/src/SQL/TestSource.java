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
			conn = ds.getConnection();//ʵ���ࣺcom.mysql.jdbc.Connection
			ps = conn.prepareStatement("...");
			
			//....
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();//���ܹأ������ӳ��ó����ͻ�Ҫ�Ż�ȥ
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
