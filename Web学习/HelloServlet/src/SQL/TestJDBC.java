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
			conn = ds.getConnection();//�ӳ���ȡ��һ������MyConnection
			ps = conn.prepareStatement("...");
			
			
			//.....
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();//��ʱ�رյ��õ����Լ�д���࣬�رղ���ʱ�����ӷŵ����ӳص����һ��
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
}
