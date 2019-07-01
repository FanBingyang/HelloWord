package cn.edu.zzuli.service;

import java.util.List;
import cn.edu.zzuli.domain.User;

/**
 * 用户的业务层接口
 */
public interface IUserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAllUser();

    List<User> findAllUser(String name);
}
