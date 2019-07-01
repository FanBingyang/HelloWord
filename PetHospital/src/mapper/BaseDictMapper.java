package mapper;

import pojo.BaseDict;
import pojo.User;

import java.util.List;

public interface BaseDictMapper {

    //查询出医生的专业
    List<BaseDict> selectVetMajor();

    //查询出动物的种类
    List<BaseDict> selectPetKind();

    //登录判断
    User getUser(User user);
}
