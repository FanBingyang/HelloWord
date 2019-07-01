package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Client;

public interface ClientMapper {

    //根据id删除客户
    void deleteClientById(Integer clientId);

    //添加新的客户
    int insertClient(Client record);

    //根据id查询客户
    Client selectClientById(Integer clientId);

    //根据条件（姓名）查询客户信息
    List<Client> selectClientByQuery(Client client);

    //查询所有客户
//    List<Client> selectClientsAll();

    //根据id修改客户信息
    int updateClient(Client record);
}