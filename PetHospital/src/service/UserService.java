package service;

import pojo.User;

import java.util.List;

public interface UserService {
    //ɾ��Ա��
    void deleteUserById(Integer userId);

    //���Ա��
    void insertUser(User user);


    //ͨ��id��ѯԱ��
    User selectUserById(Integer userId);

    //ͨ������(����,�Ա�)��ѯԱ����Ϣ
    List<User> selectUserByQuery(User user);

    //�޸�Ա����
    int updateUserById(User user);
}
