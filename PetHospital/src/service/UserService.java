package service;

import pojo.User;

import java.util.List;

public interface UserService {
    //删除员工
    void deleteUserById(Integer userId);

    //添加员工
    void insertUser(User user);


    //通过id查询员工
    User selectUserById(Integer userId);

    //通过条件(姓名,性别)查询员工信息
    List<User> selectUserByQuery(User user);

    //修改员工，
    int updateUserById(User user);
}
