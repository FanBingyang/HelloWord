package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.BaseDict;
import pojo.Ill;
import service.BaseDictService;
import service.IllService;

import java.util.List;

@Controller
public class IllController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private IllService illService;

    /**
     * Ìí¼Ó²¡Àý
     * @param ill
     * @return
     */
    @RequestMapping(value = "/insertIll.action")
    public @ResponseBody
    String insertIll(Ill ill)
    {
        illService.insertIll(ill);
        return "OK";
    }

    @RequestMapping(value = "/ill.action")
    public String ill(Ill ill,Model model)
    {
        List<BaseDict> major = baseDictService.selectVetMajor();
        List<BaseDict> kind = baseDictService.selectPetKind();
        model.addAttribute("major",major);
        model.addAttribute("kind",kind);

        List<Ill> ills = illService.selectIll(ill);
        model.addAttribute("ills",ills);

        return "ill";
    }


}
