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
			conn.setAutoCommit(false);//��������
			
			
			//�ֱ�õ�ת����ת���˻�����
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//�޸��˻����ԵĽ��
			fromAccount.setMonev(fromAccount.getMoney()-money);
			toAccount.setMonev(toAccount.getMoney()+money);
			
			ad.updateAccount(fromAccount);
//			int i = 10/0;//�쳣��ת���ɹ���ת��ʧ��
			ad.updateAccount(toAccount);
			
			
			conn.commit();//�ύ����
		} catch (Exception e) {
			try {
				conn.rollback();//�ع�����
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();//�ر�
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
