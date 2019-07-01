package service;

import pojo.Client;

import java.util.List;

public interface ClientService {
    //����idɾ���ͻ�
    void deleteClientById(Integer clientId);

    //����µĿͻ�
    int insertClient(Client record);

    //����id��ѯ�ͻ�
    Client selectClientById(Integer clientId);

    //������������������ѯ�ͻ���Ϣ
    List<Client> selectClientByQuery(Client client);


    //����id�޸Ŀͻ���Ϣ
    int updateClient(Client record);
}
