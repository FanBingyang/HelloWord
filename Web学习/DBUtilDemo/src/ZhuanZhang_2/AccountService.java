package ZhuanZhang_2;

public interface AccountService {
	/**
	 * ת��
	 * @param fromname ת���˻�
	 * @param toname ת���˻�
	 * @param money ת�˽��
	 * @throws Exception 
	 */
	public void transfer(String fromname,String toname,double money);
}
