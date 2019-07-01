package service;

import pojo.Ill;

import java.util.List;

public interface IllService {

    //添加病例
    void insertIll(Ill ill);

    //按条件查询病例
    List<Ill> selectIll(Ill ill);
}
