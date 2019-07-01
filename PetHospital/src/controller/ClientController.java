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
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PetService petService;

    /**
     * 查看客户
     * @param client
     * @param model
     * @return
     */
    @RequestMapping(value = "/client.action")
    public String client(Client client, Model model)
    {
        List<Client> clients = clientService.selectClientByQuery(client);
        model.addAttribute("clients",clients);
        return "client";
    }

    /**
     * 通过id查看用户
     * @param clientId
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectClient.action")
    public String selectClient(Integer clientId, Model model)
    {
        Client client = clientService.selectClientById(clientId);
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        model.addAttribute("clients",clients);
        return "client";
    }

    /**
     * 编辑客户信息
     * @param clientId
     * @return
     */
    @RequestMapping(value = "/editClient.action")
    public @ResponseBody
    Client editClient(Integer clientId)
    {
        return clientService.selectClientById(clientId);
    }

    /**
     * 修改用户信息
     * @param client
     * @return
     */
    @RequestMapping(value = "/updateClient.action")
    public @ResponseBody
    String updateClient(Client client)
    {
        clientService.updateClient(client);
        return "OK";
    }

    /**
     * 添加用户
     * @param client
     * @return
     */
    @RequestMapping(value = "/insertClient.action")
    public @ResponseBody
    String insertClient(Client client)
    {
        clientService.insertClient(client);
        return "OK";
    }

    /**
     * 删除用户
     * @param clidentId
     * @return
     */
    @RequestMapping(value = "/deleteClient.action")
    public @ResponseBody
    String deleteClient(Integer clidentId)
    {
        //先从用户表中删除用户
        clientService.deleteClientById(clidentId);
        //在从宠物表中删除相应的宠物
        petService.deletePetByClientId(clidentId);
        return "OK";
    }



}
