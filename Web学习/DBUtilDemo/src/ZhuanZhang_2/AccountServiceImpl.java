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
			ManagerThreadLocal.startTransacation();//��������
			
			
			//�ֱ�õ�ת����ת���˻�����
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//�޸��˻����ԵĽ��
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			
			//���ת�˲���
			ad.updateAccount(fromAccount);
//			int i = 10/0;//�쳣��ת���ɹ���ת��ʧ��
			ad.updateAccount(toAccount);
			
			
			ManagerThreadLocal.commit();//�ύ����
		} catch (Exception e) {
			try {
				ManagerThreadLocal.rollback();//�ع�����
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				ManagerThreadLocal.close();//�ر�
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
