package ZhuanZhang;


import java.sql.Connection;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import util.C3P0Util;

public class AccountDaoImpl implements AccountDao{

	private Connection conn;

	public AccountDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void updateAccount(String fromname, String toname, double money) throws Exception {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		qr.update("update zhanghu set money=money-? where name=?",money,fromname);
		qr.update("update zhanghu set money=money+? where name=?",money,toname);
		
	}

	//手动控制事务
	@Override
	public void updateAccount(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(conn,"update users set money=? where name=?",account.getMoney(),account.getName());
		
		
		
	}

	@Override
	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		return qr.query(conn,"select * from users where name=?", new BeanHandler<Account>(Account.class));
		
		
	}
	
	

}
