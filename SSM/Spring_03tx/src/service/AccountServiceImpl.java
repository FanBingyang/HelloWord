package service;

import static org.junit.Assert.fail;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import dao.AccountDao;

//��ע��д�����ϣ���ʾ�������з�����ʹ�ø�ע�⣬������ĳһ����ĳ���������ඨ�岻һ������ô���ڸ÷������ٴμ�ע�⣬
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	private TransactionTemplate tt;
	
	@Override
	//ע������aop�������񣬿��Լ��ڷ����ϣ�Ҳ���Լ�������
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from, final Integer to, final Double money) {
		
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//��Ǯ
				ad.decreaseMoney(from, money);
				//��Ǯ
				ad.inceaseMoney(to, money);
			}
		});
		
		
	}
	
//	@Override
//	public void transfer(final Integer from, final Integer to, final Double money) {
//		
//		tt.execute(new TransactionCallbackWithoutResult() {
//			
//			@Override
//			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
//				//��Ǯ
//				ad.decreaseMoney(from, money);
//				
//				//int i=10/0;
//				
//				//��Ǯ
//				ad.inceaseMoney(to, money);
//			}
//		});
//		
//		//1.������
//		//2.����doInTransactionWithoutResult����
//		//3.�ύ����
//		
//		
//	}

	/**
	 * @return the ad
	 */
	public AccountDao getAd() {
		return ad;
	}

	/**
	 * @param ad the ad to set
	 */
	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

	/**
	 * @return the tt
	 */
	public TransactionTemplate getTt() {
		return tt;
	}

	/**
	 * @param tt the tt to set
	 */
	public void setTt(TransactionTemplate tt) {
		this.tt = tt;
	}
	
	

	
}
