package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.User;

public interface UserMapper {

    //ɾ��Ա��
    void deleteUserById(Integer userId);

    //���Ա��
    void insertUser(User user);


    //ͨ��id��ѯԱ��
    User selectUserById(Integer userId);

    //ͨ������(����,�Ա�)��ѯԱ����Ϣ
    List<User> selectUserByQuery(User user);

    //��ѯ����
//    List<User> selectUsersAll();

    //�޸�Ա����
    int updateUserById(User user);
}