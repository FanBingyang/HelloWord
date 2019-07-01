package com.zls.service;

import java.sql.SQLException;

import com.zls.dao.UserDaoImp;
import com.zls.domain.User;

public class UserService {

	UserDaoImp userDao = new UserDaoImp();

	public User ckUser(String username, String userpass) {
		// TODO Auto-generated method stub
		try {
			return userDao.ckUser(username,userpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		try {
			userDao.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
