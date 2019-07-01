package cn.edu.zzuli.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity   //表示这是一个实体类
@Table(name = "user")  //表示这个类与那一张表对应
@Data  //用于生成get/set等方法
public class User implements Serializable {

    @Id  //表示是数据库中的主键
    @Column(name = "id")  //表示与数据库中那一列对应
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //表示该列是自增长
    private Integer id;

    @Column(name = "user_name")  //在windows下，mysql不区分大小写，但是在linux系统下区分
    private String user_name;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
