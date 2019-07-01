package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Vet;

public interface VetMapper {

    //����idɾ��ҽ��
    void deleteVetById(Integer vetId);

    //��������(���֣�רҵ)��ѯҽ��
    List<Vet> selectVetByQuery(Vet vet);

    //���ҽ��
    int insertVet(Vet record);

    //����id��ѯҽ��
    Vet selectVetById(Integer vetId);

    //�޸�ҽ����Ϣ
    int updateVet(Vet vet);

}