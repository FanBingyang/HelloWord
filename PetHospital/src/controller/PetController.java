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
     * 查看宠物
     * @param pet
     * @param model
     * @return
     */
    @RequestMapping(value = "/pet.action")
    public String pet(Pet pet, Model model)
    {
        //先查出宠物的种类
        List<BaseDict> kinds = baseDictService.selectPetKind();
        model.addAttribute("kinds",kinds);

        List<Pet> pets = petService.selectPetByQuery(pet);
        //用迭代器遍历查询文章的集合,
        for (Iterator iterators = pets.iterator(); iterators.hasNext();)
        {
            Pet p = (Pet) iterators.next();//获取当前遍历的元素，指定为Article对象
            //通过文章中的作者id查询出该作者信息
            Client client = clientService.selectClientById(p.getClientId());
            //将查询出来的作者信息存放到对应的文章的JavaBean中
            p.setClient(client);
        }
        model.addAttribute("pets",pets);
        return "pet";
    }

//    /**
//     * 通过宠物id查询宠物信息
//     * @param petName
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/selectPetName.action")
//    public String selectPetId(String petName, Model model)
//    {
//        //先查出宠物的种类
//        List<BaseDict> kinds = baseDictService.selectPetKind();
//        model.addAttribute("kinds",kinds);
//
//        Pet pet = petService.selectPetById(petId);
//
//        List<Pet> pets = new ArrayList<>();
//        pets.add(pet);
//
//        //用迭代器遍历查询宠物的集合,
//        for (Iterator iterators = pets.iterator(); iterators.hasNext();)
//        {
//            Pet p = (Pet) iterators.next();//获取当前遍历的元素，指定为Pet对象
//            //通过宠物中的用户id查询出该用户的信息
//            Client client = clientService.selectClientById(p.getClientId());
//            //将查询出来的用户信息存放到对应的宠物的JavaBean中
//            p.setClient(client);
//        }
//        model.addAttribute("pets",pets);
//        return "pet";
//    }

    /**
     * 通过客户id查询宠物信息
     * @param clientId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectPetByClientId.action")
    public String selectPetByClientId(Integer clientId, Model model)
    {
        //先查出宠物的种类
        List<BaseDict> kinds = baseDictService.selectPetKind();
        model.addAttribute("kinds",kinds);

        List<Pet> pets = petService.selectPetByClientId(clientId);
        //用迭代器遍历查询文章的集合,
        for (Iterator iterators = pets.iterator(); iterators.hasNext();)
        {
            Pet p = (Pet) iterators.next();//获取当前遍历的元素，指定为Article对象
            //通过文章中的作者id查询出该作者信息
            Client client = clientService.selectClientById(p.getClientId());
            //将查询出来的作者信息存放到对应的文章的JavaBean中
            p.setClient(client);
        }
        model.addAttribute("pets",pets);
        return "pet";
    }


    /**
     * 编辑宠物信息
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
     * 修改宠物信息
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
     * 添加宠物
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
     * 删除宠物
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
