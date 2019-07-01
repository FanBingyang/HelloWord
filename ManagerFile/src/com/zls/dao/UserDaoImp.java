package com.zls.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zls.domain.User;
import com.zls.util.C3P0Util;

public class UserDaoImp {

	public User ckUser(String username, String userpass) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from users where username=? and userpass=?", new BeanHandler<User>(User.class),username,userpass);
	}

	public void addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("insert into users value(?,?,?,?)",0,user.getUsername(),user.getUserpass(),user.getUseremail());
	}

}
