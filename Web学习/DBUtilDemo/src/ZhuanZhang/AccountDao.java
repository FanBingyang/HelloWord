package ZhuanZhang;

public interface AccountDao {
	
	/**
	 * 转账
	 * @param fromname 转出账户
	 * @param toname 转入账户
	 * @param money 转账金额
	 * @throws Exception 
	 */
	@Deprecated  //过时
	public void updateAccount(String fromname,String toname,double money) throws Exception;

	/**
	 * 根据账户信息进行修改金额
	 * @param account
	 */
	public void updateAccount(Account account) throws Exception;
	
	/**
	 * 根据用户姓名查找用户信息
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
	
}
