package MVC;

public interface UserService {
	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @throws Exception
	 */
		public void register(User user)throws Exception;
		
		/**
		 * 根据用户名和密码查找用户信息
		 * @param user
		 * @return
		 * @throws Exception
		 */
		public User login(User user) throws UsersException;
		
		/**
		 * 根据用户名查找用户是否存在
		 * @return
		 * @throws UserExistException
		 */
		public boolean findUserByName(String name) throws UserExistException;
} 
