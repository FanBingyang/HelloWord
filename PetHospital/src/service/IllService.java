package service;

import pojo.Ill;

import java.util.List;

public interface IllService {

    //��Ӳ���
    void insertIll(Ill ill);

    //��������ѯ����
    List<Ill> selectIll(Ill ill);
}
