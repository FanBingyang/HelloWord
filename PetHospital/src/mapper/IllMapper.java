package mapper;

import pojo.Ill;

import java.util.List;

public interface IllMapper {
    //��Ӳ���
    void insertIll(Ill ill);

    //��������ѯ����
    List<Ill> selectIll(Ill ill);

    //������ɾ������
    void deleteIll(Ill ill);
}
