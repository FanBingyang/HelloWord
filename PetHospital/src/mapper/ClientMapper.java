package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Client;

public interface ClientMapper {

    //����idɾ���ͻ�
    void deleteClientById(Integer clientId);

    //����µĿͻ�
    int insertClient(Client record);

    //����id��ѯ�ͻ�
    Client selectClientById(Integer clientId);

    //������������������ѯ�ͻ���Ϣ
    List<Client> selectClientByQuery(Client client);

    //��ѯ���пͻ�
//    List<Client> selectClientsAll();

    //����id�޸Ŀͻ���Ϣ
    int updateClient(Client record);
}