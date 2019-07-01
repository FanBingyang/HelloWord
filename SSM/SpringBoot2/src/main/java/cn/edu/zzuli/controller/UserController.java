package cn.edu.zzuli.controller;

import cn.edu.zzuli.domain.User;
import cn.edu.zzuli.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户的控制
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll/{name}")
    public List<User> findAllUser(@PathVariable("name") String name){
        List<User> users1 = userService.findAllUser();

        List<User> users =  userService.findAllUser(name);
        return users1;
    }

    @RequestMapping("/findAll")
    public List<User> findAllUser(){
        List<User> users = userService.findAllUser();
        return users;
    }
}
