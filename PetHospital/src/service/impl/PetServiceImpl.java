package service.impl;

import mapper.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Pet;
import service.PetService;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetMapper petMapper;

    /**
     * ����idɾ������
     * @param petId
     */
    @Override
    public void deletePetById(Integer petId) {
        petMapper.deletePetById(petId);
    }

    /**
     * ���ݿͻ�idɾ������
     * @param clientId
     */
    @Override
    public void deletePetByClientId(Integer clientId) {
        petMapper.deletePetByClientId(clientId);
    }

    /**
     * ��ӳ���
     * @param pet
     * @return
     */
    @Override
    public int insertPet(Pet pet) {
        return petMapper.insertPet(pet);
    }

    /**
     * ����id��ѯ����
     * @param petId
     * @return
     */
    @Override
    public Pet selectPetById(Integer petId) {
        return petMapper.selectPetById(petId);
    }

    /**
     * �������������������ࣩ��ѯ����
     * @param pet
     * @return
     */
    @Override
    public List<Pet> selectPetByQuery(Pet pet) {
        return petMapper.selectPetByQuery(pet);
    }

    /**
     * �޸ĳ�����Ϣ
     * @param pet
     * @return
     */
    @Override
    public int updatePetById(Pet pet) {
        return petMapper.updatePetById(pet);
    }

    /**
     * ͨ���û�id��ѯ������Ϣ
     * @param clientId
     * @return
     */
    @Override
    public List<Pet> selectPetByClientId(Integer clientId) {
        return petMapper.selectPetByClientId(clientId);
    }
}
