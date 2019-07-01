package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import org.junit.Test;

public class TestTransaction {

	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtils.getConnection();
			//���ü���Ϊ3��mysqlĬ�ϵļ���
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			
			conn.setAutoCommit(false);//�൱�� �������� begin
			ps = conn.prepareStatement("update zhanghu set money=money-100 where name='aaa'");
			ps.executeUpdate();
			
			ps = conn.prepareStatement("update zhanghu set money=money+100 where name='bbb'");
			ps.executeUpdate();
			
			conn.commit();//�ύ���� commit
		}catch (Exception e) {
			try {
				conn.rollback();//�ع�����
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	}
	
}
