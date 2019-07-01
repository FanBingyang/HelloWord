package cn.edu.zzuli.dao;

import cn.edu.zzuli.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户的持久层接口
 */
//继承JpaRepository<User,Integer>，spring就会提供查询所有的方法，
// 第一个参数是要操作得类，第二个参数是主键的类型
//***  没有使用成功
@Repository("IUserDao")
//@EnableJpaRepositories("cn.edu.zzuli.dao")
public interface IUserDao{
    /**
     * 查询所有用户
     */
//    @Select("select * from user")
    List<User> findAllUser();
}
