package ZhuanZhang_2;


import java.sql.Connection;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.C3P0Util;

public class AccountDaoImpl implements AccountDao{

	
	@Override
	public void updateAccount(String fromname, String toname, double money) throws Exception {
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		qr.update("update zhanghu set money=money-? where name=?",money,fromname);
		qr.update("update zhanghu set money=money+? where name=?",money,toname);
		
	}

	//�ֶ���������
	@Override
	public void updateAccount(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(ManagerThreadLocal.getConnection(),"update zhanghu set money=? where name=?",account.getMoney(),account.getName());
		
		
		
	}

	@Override
	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		return qr.query(ManagerThreadLocal.getConnection(),"select * from zhanghu where name=?", new BeanHandler<Account>(Account.class),name);
		
		
	}
	
	

}
