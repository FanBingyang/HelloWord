package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查看用户
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/user.action")
    public String user(User user, Model model)
    {
        List<User> users = userService.selectUserByQuery(user);
        model.addAttribute("users",users);
        return "user";
    }

    /**
     * 编辑用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/editUser.action")
    public @ResponseBody
    User editUser(Integer userId)
    {
        System.out.println(userId);
        return userService.selectUserById(userId);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser.action")
    public @ResponseBody
    String updateUser(User user)
    {
        userService.updateUserById(user);
        return "OK";
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/insertUser.action")
    public @ResponseBody
    String insertUser(User user)
    {
        userService.insertUser(user);
        return "OK";
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @RequestMapping(value = "/deleteUser.action")
    public @ResponseBody
    String deleteUser(Integer userId)
    {
        userService.deleteUserById(userId);
        return "OK";
    }
}
