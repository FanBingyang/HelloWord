package ZhuanZhang_2;

import java.sql.Connection;
import java.sql.SQLException;

import util.C3P0Util;

public class AccountServiceImpl implements AccountService {

	
	
	
	@Override
	public void transfer(String fromname, String toname, double money) {
		
//		ad.updateAccount(fromname, toname, money);
		
		
		AccountDao ad = new AccountDaoImpl();

		
		try {
			ManagerThreadLocal.startTransacation();//开启事务
			
			
			//分别得到转出和转入账户对象
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//修改账户各自的金额
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			
			//完成转账操作
			ad.updateAccount(fromAccount);
//			int i = 10/0;//异常后转出成功，转入失败
			ad.updateAccount(toAccount);
			
			
			ManagerThreadLocal.commit();//提交事务
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();//回滚事务
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ManagerThreadLocal.close();//关闭
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
