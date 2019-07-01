package cn.edu.zzuli.web;

import cn.edu.zzuli.pojo.User;
import cn.edu.zzuli.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController  //使用这个注解，方法上不用写@ResponseBody
//@Controller
@Slf4j
@RequestMapping("user")
public class HelloController {

//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User hello(@PathVariable("id") int id){
        return userService.queryById(id);
    }
}
