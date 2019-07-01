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
 * ��ҽ���Ĳ���
 */
@Controller
public class VetController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private VetService vetService;

    /**
     * �鿴ҽ��
     * @param vet
     * @param model
     * @return
     */
    @RequestMapping(value = "/vet.action")
    public String vet(Vet vet, Model model)
    {
        //��ѯ��ҽ����רҵ��Ȼ���ǰ��������
        List<BaseDict> major = baseDictService.selectVetMajor();
        //�����ݷ�����ͼ
        model.addAttribute("major",major);

        //��������ѯҽ��
        List<Vet> vets = vetService.selectVetByQuery(vet);
        model.addAttribute("vets",vets);

        //��ת��ͼ
        return "vet";
    }

    /**
     * �ڷ�����ע��@ResponseBody
     * ��ʾ�÷����ķ��ؽ��ֱ��д��HTTP response body��,
     * һ�����첽��ȡ����ʱʹ�ã���ʹ��@RequestMapping�󣬷���ֵͨ������Ϊ��ת·��
     * ����@responsebody�󷵻ؽ�����ᱻ����Ϊ��ת·��������ֱ��д��HTTP response body�С�
     * */
    /**
     * �༭ҽ����Ϣ
     * @param vetId
     * @return
     */
    @RequestMapping(value = "/editVet.action")
    public @ResponseBody
    Vet editVet(Integer vetId)
    {
        //ͨ��id��ҽ����ѯ������Ȼ�������ͼ��
//        System.out.println(vetId);
        Vet v = vetService.selectVetById(vetId);
//        System.out.println(v);
        return vetService.selectVetById(vetId);
    }

    /**
     * �޸�ҽ����Ϣ
     * @param vet
     * @return
     */
    @RequestMapping(value = "/updateVet.action")
    public @ResponseBody
    String updateVet(Vet vet)
    {
        vetService.updateVet(vet);
        //�����ַ���"OK"����Ϊ����Ļص����������ַ���OK
        return "OK";
    }

    /**
     * ���ҽ��
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
     * ɾ��ҽ��
     * @param vetId
     * @return
     */
    @RequestMapping(value = "/deleteVet.action")
    public @ResponseBody
    String deleteVet(Integer vetId)
    {
        //ɾ��ҽ��
        vetService.deleteVetById(vetId);
        return "OK";
    }


}
