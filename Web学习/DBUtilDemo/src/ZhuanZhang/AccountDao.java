package ZhuanZhang;

public interface AccountDao {
	
	/**
	 * ת��
	 * @param fromname ת���˻�
	 * @param toname ת���˻�
	 * @param money ת�˽��
	 * @throws Exception 
	 */
	@Deprecated  //��ʱ
	public void updateAccount(String fromname,String toname,double money) throws Exception;

	/**
	 * �����˻���Ϣ�����޸Ľ��
	 * @param account
	 */
	public void updateAccount(Account account) throws Exception;
	
	/**
	 * �����û����������û���Ϣ
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name) throws Exception;
	
}
