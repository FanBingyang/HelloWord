package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Ill;
import pojo.IllExample;

public interface IllMapper {
    int countByExample(IllExample example);

    int deleteByExample(IllExample example);

    int insert(Ill record);

    int insertSelective(Ill record);

    List<Ill> selectByExample(IllExample example);

    int updateByExampleSelective(@Param("record") Ill record, @Param("example") IllExample example);

    int updateByExample(@Param("record") Ill record, @Param("example") IllExample example);
}