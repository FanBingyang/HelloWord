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

//将注解写在类上，表示类中所有方法都使用该注解，若类中某一方法某个参数和类定义不一样，那么可在该方法上再次加注解，
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements AccountService {

	private AccountDao ad;
	private TransactionTemplate tt;
	
	@Override
	//注解配置aop管理事务，可以加在方法上，也可以加在类上
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(final Integer from, final Integer to, final Double money) {
		
		tt.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				//减钱
				ad.decreaseMoney(from, money);
				//加钱
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
//				//减钱
//				ad.decreaseMoney(from, money);
//				
//				//int i=10/0;
//				
//				//加钱
//				ad.inceaseMoney(to, money);
//			}
//		});
//		
//		//1.打开事务
//		//2.调用doInTransactionWithoutResult方法
//		//3.提交事务
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
