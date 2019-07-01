package cn.edu.zzuli.service.impl;

import cn.edu.zzuli.dao.IUserDao;
import cn.edu.zzuli.dao.IUserMapper;
import cn.edu.zzuli.domain.User;
import cn.edu.zzuli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的业务层实现类
 */
@Service("userService")
public class UserServiceImpl implements IUserService
{
    @Autowired
    private IUserDao userDao; //spring data jpa 实现



    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }

    @Autowired
    private IUserMapper userMapper;

    @Override
    public List<User> findAllUser(String name) {
        return userMapper.queryUserByName(name);
    }


}
