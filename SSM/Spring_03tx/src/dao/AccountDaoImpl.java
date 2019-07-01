package dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{
	
	//��Ǯ
	@Override
	public void decreaseMoney(Integer id, Double money) {
		getJdbcTemplate().update("update zhanghu set money = money - ? where id = ?",money,id);
		
	}
	
	//��Ǯ
	@Override
	public void inceaseMoney(Integer id, Double money) {
		getJdbcTemplate().update("update zhanghu set money = money + ? where id = ?",money,id);
		
	}
}
