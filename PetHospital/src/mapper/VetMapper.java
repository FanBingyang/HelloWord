package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Vet;

public interface VetMapper {

    //根据id删除医生
    void deleteVetById(Integer vetId);

    //根据条件(名字，专业)查询医生
    List<Vet> selectVetByQuery(Vet vet);

    //添加医生
    int insertVet(Vet record);

    //根据id查询医生
    Vet selectVetById(Integer vetId);

    //修改医生信息
    int updateVet(Vet vet);

}