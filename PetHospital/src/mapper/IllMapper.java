package mapper;

import pojo.Ill;

import java.util.List;

public interface IllMapper {
    //添加病例
    void insertIll(Ill ill);

    //按条件查询病例
    List<Ill> selectIll(Ill ill);

    //按条件删除病例
    void deleteIll(Ill ill);
}
