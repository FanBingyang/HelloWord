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
     * ����idɾ���û�
     * @param userId
     */
    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }

    /**
     * ����û�
     * @param user
     */
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    /**
     * ����id��ѯ�û�
     * @param userId
     * @return
     */
    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * �����������������Ա𣩲�ѯ�û�
     * @param user
     * @return
     */
    @Override
    public List<User> selectUserByQuery(User user) {
        return userMapper.selectUserByQuery(user);
    }

    /**
     * �޸��û���Ϣ
     * @param user
     * @return
     */
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }
}
