package service;

import pojo.Pet;

import java.util.List;

public interface PetService {
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

    //�޸ĳ�����Ϣ
    int updatePetById(Pet pet);

    //ͨ���û�id��ѯ����
    List<Pet> selectPetByClientId(Integer clientId);
}
