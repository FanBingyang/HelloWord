package service.impl;

import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id删除用户
     * @param userId
     */
    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 根据条件（姓名，性别）查询用户
     * @param user
     * @return
     */
    @Override
    public List<User> selectUserByQuery(User user) {
        return userMapper.selectUserByQuery(user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }
}
