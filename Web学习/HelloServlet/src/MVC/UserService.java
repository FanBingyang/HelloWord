package MVC;

public interface UserService {
	/**
	 * ����û���Ϣ
	 * 
	 * @param user
	 * @throws Exception
	 */
		public void register(User user)throws Exception;
		
		/**
		 * �����û�������������û���Ϣ
		 * @param user
		 * @return
		 * @throws Exception
		 */
		public User login(User user) throws UsersException;
		
		/**
		 * �����û��������û��Ƿ����
		 * @return
		 * @throws UserExistException
		 */
		public boolean findUserByName(String name) throws UserExistException;
} 
