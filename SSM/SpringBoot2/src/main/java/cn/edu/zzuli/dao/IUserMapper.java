package cn.edu.zzuli.dao;

import cn.edu.zzuli.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 使用mybatis实现对数据库的操作接口
 */
@Mapper   //要求mybatis本版本是3.3以上
public interface IUserMapper {
    @Select("select * from user where name like '%${value}%'")
    public List<User> queryUserByName(String name);
}
