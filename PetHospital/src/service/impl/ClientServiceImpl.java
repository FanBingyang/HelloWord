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
     * ����idɾ���ͻ�
     * @param clientId
     */
    @Override
    public void deleteClientById(Integer clientId) {
        //ɾ���ͻ���Ϣ
        clientMapper.deleteClientById(clientId);
        //ɾ���ͻ��ĳ�����Ϣ
        petMapper.deletePetByClientId(clientId);
    }

    /**
     * ����û�
     * @param record
     * @return
     */
    @Override
    public int insertClient(Client record) {
        return clientMapper.insertClient(record);
    }

    /**
     * ����id��ѯ�ͻ�
     * @param clientId
     * @return
     */
    @Override
    public Client selectClientById(Integer clientId) {
        return clientMapper.selectClientById(clientId);
    }

    /**
     * ����������������ѯ�ͻ�
     * @param client
     * @return
     */
    @Override
    public List<Client> selectClientByQuery(Client client) {
        return clientMapper.selectClientByQuery(client);
    }

    /**
     * �޸Ŀͻ���Ϣ
     * @param record
     * @return
     */
    @Override
    public int updateClient(Client record) {
        return clientMapper.updateClient(record);
    }
}
