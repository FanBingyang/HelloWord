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
     * �鿴�ͻ�
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
     * ͨ��id�鿴�û�
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
     * �༭�ͻ���Ϣ
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
     * �޸��û���Ϣ
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
     * ����û�
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
     * ɾ���û�
     * @param clidentId
     * @return
     */
    @RequestMapping(value = "/deleteClient.action")
    public @ResponseBody
    String deleteClient(Integer clidentId)
    {
        //�ȴ��û�����ɾ���û�
        clientService.deleteClientById(clidentId);
        //�ڴӳ������ɾ����Ӧ�ĳ���
        petService.deletePetByClientId(clidentId);
        return "OK";
    }



}
