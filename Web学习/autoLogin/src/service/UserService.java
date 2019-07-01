package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;

public class UserService {
	UserDao ud = new UserDao();
	public User findUser(String username, String password) {
		
		try {
			return ud.findUser(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
