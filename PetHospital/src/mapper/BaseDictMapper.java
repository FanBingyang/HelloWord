package mapper;

import pojo.BaseDict;
import pojo.User;

import java.util.List;

public interface BaseDictMapper {

    //��ѯ��ҽ����רҵ
    List<BaseDict> selectVetMajor();

    //��ѯ�����������
    List<BaseDict> selectPetKind();

    //��¼�ж�
    User getUser(User user);
}
