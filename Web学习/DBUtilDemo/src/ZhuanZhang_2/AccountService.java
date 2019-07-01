package ZhuanZhang_2;

public interface AccountService {
	/**
	 * 转账
	 * @param fromname 转出账户
	 * @param toname 转入账户
	 * @param money 转账金额
	 * @throws Exception 
	 */
	public void transfer(String fromname,String toname,double money);
}
