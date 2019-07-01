package MVC;

public interface UserDao {
/**
 * ����û���Ϣ
 * 
 * @param user
 * @throws Exception
 */
	public void addUser(User user)throws Exception;
	
	/**
	 * �����û�������������û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findUser(User user)throws Exception;
	
	/**
	 * �����û��������û��Ƿ����
	 * @param name
	 * @return
	 */
	public boolean findUserByName(String name);
}
