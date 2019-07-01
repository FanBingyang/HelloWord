package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pojo.BaseDict;
import pojo.User;
import pojo.Vet;
import service.BaseDictService;
import service.UserService;
import service.VetService;

import java.util.List;

@Controller
@SessionAttributes("UserName")
public class BaseDictController {

    @Autowired
    private BaseDictService baseDictService;

    /**
     * �жϵ�¼�Ƿ�ɹ�
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/login.action")
    public String login(User user, Model model)
    {
        if(baseDictService.getUser(user))
        {
            model.addAttribute("UserName",user.getUserName());
            //��ת����һ��action
            return "redirect:vet.action";
        }else {
            model.addAttribute("error","�û������������!");
            return "index";
        }
    }

}
