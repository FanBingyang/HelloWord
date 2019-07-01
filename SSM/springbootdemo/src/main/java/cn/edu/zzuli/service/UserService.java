package cn.edu.zzuli.service;

import cn.edu.zzuli.mapper.UserMapper;
import cn.edu.zzuli.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(int id)
    {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional    //注解事务
    public void insertUser(User user)
    {
        userMapper.insert(user);
    }
}
