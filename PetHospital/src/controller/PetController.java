package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.BaseDict;
import pojo.Client;
import pojo.Pet;
import service.BaseDictService;
import service.ClientService;
import service.PetService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class PetController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private PetService petService;

    @Autowired
    private ClientService clientService;

    /**
     * �鿴����
     * @param pet
     * @param model
     * @return
     */
    @RequestMapping(value = "/pet.action")
    public String pet(Pet pet, Model model)
    {
        //�Ȳ�����������
        List<BaseDict> kinds = baseDictService.selectPetKind();
        model.addAttribute("kinds",kinds);

        List<Pet> pets = petService.selectPetByQuery(pet);
        //�õ�����������ѯ���µļ���,
        for (Iterator iterators = pets.iterator(); iterators.hasNext();)
        {
            Pet p = (Pet) iterators.next();//��ȡ��ǰ������Ԫ�أ�ָ��ΪArticle����
            //ͨ�������е�����id��ѯ����������Ϣ
            Client client = clientService.selectClientById(p.getClientId());
            //����ѯ������������Ϣ��ŵ���Ӧ�����µ�JavaBean��
            p.setClient(client);
        }
        model.addAttribute("pets",pets);
        return "pet";
    }

//    /**
//     * ͨ������id��ѯ������Ϣ
//     * @param petName
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/selectPetName.action")
//    public String selectPetId(String petName, Model model)
//    {
//        //�Ȳ�����������
//        List<BaseDict> kinds = baseDictService.selectPetKind();
//        model.addAttribute("kinds",kinds);
//
//        Pet pet = petService.selectPetById(petId);
//
//        List<Pet> pets = new ArrayList<>();
//        pets.add(pet);
//
//        //�õ�����������ѯ����ļ���,
//        for (Iterator iterators = pets.iterator(); iterators.hasNext();)
//        {
//            Pet p = (Pet) iterators.next();//��ȡ��ǰ������Ԫ�أ�ָ��ΪPet����
//            //ͨ�������е��û�id��ѯ�����û�����Ϣ
//            Client client = clientService.selectClientById(p.getClientId());
//            //����ѯ�������û���Ϣ��ŵ���Ӧ�ĳ����JavaBean��
//            p.setClient(client);
//        }
//        model.addAttribute("pets",pets);
//        return "pet";
//    }

    /**
     * ͨ���ͻ�id��ѯ������Ϣ
     * @param clientId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectPetByClientId.action")
    public String selectPetByClientId(Integer clientId, Model model)
    {
        //�Ȳ�����������
        List<BaseDict> kinds = baseDictService.selectPetKind();
        model.addAttribute("kinds",kinds);

        List<Pet> pets = petService.selectPetByClientId(clientId);
        //�õ�����������ѯ���µļ���,
        for (Iterator iterators = pets.iterator(); iterators.hasNext();)
        {
            Pet p = (Pet) iterators.next();//��ȡ��ǰ������Ԫ�أ�ָ��ΪArticle����
            //ͨ�������е�����id��ѯ����������Ϣ
            Client client = clientService.selectClientById(p.getClientId());
            //����ѯ������������Ϣ��ŵ���Ӧ�����µ�JavaBean��
            p.setClient(client);
        }
        model.addAttribute("pets",pets);
        return "pet";
    }


    /**
     * �༭������Ϣ
     * @param petId
     * @return
     */
    @RequestMapping(value = "/editPet.action")
    public @ResponseBody
    Pet editPet(Integer petId)
    {
        return petService.selectPetById(petId);
    }

    /**
     * �޸ĳ�����Ϣ
     * @param pet
     * @return
     */
    @RequestMapping(value = "/updatePet.action")
    public @ResponseBody
    String updatePet(Pet pet)
    {
        petService.updatePetById(pet);
        return "OK";
    }

    /**
     * ��ӳ���
     * @param pet
     * @return
     */
    @RequestMapping(value = "/insertPet.action")
    public @ResponseBody
    String insertPet(Pet pet)
    {
        petService.insertPet(pet);
        return "OK";
    }

    /**
     * ɾ������
     * @param petId
     * @return
     */
    @RequestMapping(value = "/deletePet.action")
    public @ResponseBody
    String deletePet(Integer petId)
    {
        petService.deletePetById(petId);
        return "OK";
    }


}
