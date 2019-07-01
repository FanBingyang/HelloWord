package service.impl;

import mapper.ClientMapper;
import mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Client;
import service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private PetMapper petMapper;

    /**
     * 根据id删除客户
     * @param clientId
     */
    @Override
    public void deleteClientById(Integer clientId) {
        //删除客户信息
        clientMapper.deleteClientById(clientId);
        //删除客户的宠物信息
        petMapper.deletePetByClientId(clientId);
    }

    /**
     * 添加用户
     * @param record
     * @return
     */
    @Override
    public int insertClient(Client record) {
        return clientMapper.insertClient(record);
    }

    /**
     * 根据id查询客户
     * @param clientId
     * @return
     */
    @Override
    public Client selectClientById(Integer clientId) {
        return clientMapper.selectClientById(clientId);
    }

    /**
     * 按条件（姓名）查询客户
     * @param client
     * @return
     */
    @Override
    public List<Client> selectClientByQuery(Client client) {
        return clientMapper.selectClientByQuery(client);
    }

    /**
     * 修改客户信息
     * @param record
     * @return
     */
    @Override
    public int updateClient(Client record) {
        return clientMapper.updateClient(record);
    }
}
