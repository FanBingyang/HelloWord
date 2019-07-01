package ZhuanZhang;

import java.sql.Connection;
import java.sql.SQLException;

import util.C3P0Util;

public class AccountServiceImpl implements AccountService {

	
	
	
	@Override
	public void transfer(String fromname, String toname, double money) {
		
//		ad.updateAccount(fromname, toname, money);
		
		Connection conn = C3P0Util.getConnection();
		AccountDao ad = new AccountDaoImpl(conn);

		
		try {
			conn.setAutoCommit(false);//开启事务
			
			
			//分别得到转出和转入账户对象
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//修改账户各自的金额
			fromAccount.setMonev(fromAccount.getMoney()-money);
			toAccount.setMonev(toAccount.getMoney()+money);
			
			ad.updateAccount(fromAccount);
//			int i = 10/0;//异常后转出成功，转入失败
			ad.updateAccount(toAccount);
			
			
			conn.commit();//提交事务
		} catch (Exception e) {
			try {
				conn.rollback();//回滚事务
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();//关闭
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
