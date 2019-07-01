package cn.edu.zzuli.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Table(name = "tb_user")    //指定该JavaBean对应的数据库表
public class User {
    //用户id
    @Id  //指定属性为主键
    @KeySql(useGeneratedKeys = true)   //主键是自增
    private int id;

    /** 小知识：
    @Transient
    这个注解是注解在属性上的，表示数据库中不存在这个值，不用虚拟到数据库
    */

    //用户名
    private String userName;
    //密码
    private String password;
    //姓名
    private String name;
    //年龄
    private int age;
    //性别，1是男，2是女
    private int sex;
    //备注信息
    private String note;



}
