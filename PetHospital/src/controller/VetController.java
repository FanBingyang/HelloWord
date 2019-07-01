package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.BaseDict;
import pojo.Vet;
import service.BaseDictService;
import service.VetService;

import java.util.List;

/**
 * 对医生的操作
 */
@Controller
public class VetController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private VetService vetService;

    /**
     * 查看医生
     * @param vet
     * @param model
     * @return
     */
    @RequestMapping(value = "/vet.action")
    public String vet(Vet vet, Model model)
    {
        //查询出医生的专业，然后给前端下拉框
        List<BaseDict> major = baseDictService.selectVetMajor();
        //将数据放入视图
        model.addAttribute("major",major);

        //按条件查询医生
        List<Vet> vets = vetService.selectVetByQuery(vet);
        model.addAttribute("vets",vets);

        //跳转视图
        return "vet";
    }

    /**
     * 在方法上注解@ResponseBody
     * 表示该方法的返回结果直接写入HTTP response body中,
     * 一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径
     * 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。
     * */
    /**
     * 编辑医生信息
     * @param vetId
     * @return
     */
    @RequestMapping(value = "/editVet.action")
    public @ResponseBody
    Vet editVet(Integer vetId)
    {
        //通过id将医生查询出来，然后放在视图里
//        System.out.println(vetId);
        Vet v = vetService.selectVetById(vetId);
//        System.out.println(v);
        return vetService.selectVetById(vetId);
    }

    /**
     * 修改医生信息
     * @param vet
     * @return
     */
    @RequestMapping(value = "/updateVet.action")
    public @ResponseBody
    String updateVet(Vet vet)
    {
        vetService.updateVet(vet);
        //返回字符串"OK"是因为界面的回调函数接受字符串OK
        return "OK";
    }

    /**
     * 添加医生
     * @param vet
     * @return
     */
    @RequestMapping(value = "/insertVet.action")
    public @ResponseBody
    String insertVet(Vet vet)
    {
        vetService.insertVet(vet);
        return "OK";
    }

    /**
     * 删除医生
     * @param vetId
     * @return
     */
    @RequestMapping(value = "/deleteVet.action")
    public @ResponseBody
    String deleteVet(Integer vetId)
    {
        //删除医生
        vetService.deleteVetById(vetId);
        return "OK";
    }


}
