package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {

    //删除员工
    void deleteUserById(Integer userId);

    //添加员工
    void insertUser(User user);


    //通过id查询员工
    User selectUserById(Integer userId);

    //通过条件(姓名,性别)查询员工信息
    List<User> selectUserByQuery(User user);

    //查询所有
//    List<User> selectUsersAll();

    //修改员工，
    int updateUserById(User user);
}