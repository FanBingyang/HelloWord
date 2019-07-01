package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Pet;

public interface PetMapper {

    //ͨ��idɾ��������Ϣ
    void deletePetById(Integer petId);

    //�����û�idɾ������
    void deletePetByClientId(Integer clientId);

    //��ӳ�����Ϣ
    int insertPet(Pet pet);

    //ͨ��id��ѯ������Ϣ
    Pet selectPetById(Integer petId);

    //��������(����������)��ѯ������Ϣ
    List<Pet> selectPetByQuery(Pet pet);

    //��ѯ���г���
//    List<Pet> selectPetsAll();

    //�޸ĳ�����Ϣ
    int updatePetById(Pet pet);

    //ͨ���û�id��ѯ����
    List<Pet> selectPetByClientId(Integer clientId);
}