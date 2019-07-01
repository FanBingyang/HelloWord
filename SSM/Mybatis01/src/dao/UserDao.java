package dao;

import pojo.User;

public interface UserDao {

	//通过用户ID查询一个用户
	public User selectUserById(Integer id);
}
