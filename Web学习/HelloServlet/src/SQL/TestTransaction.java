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
			//设置级别为3，mysql默认的级别
			conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			
			conn.setAutoCommit(false);//相当于 开启事务 begin
			ps = conn.prepareStatement("update zhanghu set money=money-100 where name='aaa'");
			ps.executeUpdate();
			
			ps = conn.prepareStatement("update zhanghu set money=money+100 where name='bbb'");
			ps.executeUpdate();
			
			conn.commit();//提交事务 commit
		}catch (Exception e) {
			try {
				conn.rollback();//回滚事务
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	}
	
}
