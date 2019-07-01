package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Vet;
import pojo.VetExample;

public interface VetMapper {
    int countByExample(VetExample example);

    int deleteByExample(VetExample example);

    int deleteByPrimaryKey(Integer vetId);

    int insert(Vet record);

    int insertSelective(Vet record);

    List<Vet> selectByExample(VetExample example);

    Vet selectByPrimaryKey(Integer vetId);

    int updateByExampleSelective(@Param("record") Vet record, @Param("example") VetExample example);

    int updateByExample(@Param("record") Vet record, @Param("example") VetExample example);

    int updateByPrimaryKeySelective(Vet record);

    int updateByPrimaryKey(Vet record);
}