package MVC;

import org.omg.CORBA.UserException;

public class UserServletImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	@Override
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}
	@Override
	public User login(User user) throws UsersException {
		// TODO Auto-generated method stub
		User u = null;
		try {
			u = userDao.findUser(user);
			if(u==null)
			{
				throw new UsersException("�û��������벻��ȷ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//д����־
		}
		return u;
	}
	@Override
	public boolean findUserByName(String name) throws UserExistException {
		// TODO Auto-generated method stub
		boolean b =  userDao.findUserByName(name);
		if(b) {
			throw new UserExistException("�û����Ѵ���");
		}
		return b;
	}
	
	
		
		
}
