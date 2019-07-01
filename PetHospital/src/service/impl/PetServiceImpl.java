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
     * 根据id删除宠物
     * @param petId
     */
    @Override
    public void deletePetById(Integer petId) {
        petMapper.deletePetById(petId);
    }

    /**
     * 根据客户id删除宠物
     * @param clientId
     */
    @Override
    public void deletePetByClientId(Integer clientId) {
        petMapper.deletePetByClientId(clientId);
    }

    /**
     * 添加宠物
     * @param pet
     * @return
     */
    @Override
    public int insertPet(Pet pet) {
        return petMapper.insertPet(pet);
    }

    /**
     * 根据id查询宠物
     * @param petId
     * @return
     */
    @Override
    public Pet selectPetById(Integer petId) {
        return petMapper.selectPetById(petId);
    }

    /**
     * 根据条件（姓名，种类）查询宠物
     * @param pet
     * @return
     */
    @Override
    public List<Pet> selectPetByQuery(Pet pet) {
        return petMapper.selectPetByQuery(pet);
    }

    /**
     * 修改宠物信息
     * @param pet
     * @return
     */
    @Override
    public int updatePetById(Pet pet) {
        return petMapper.updatePetById(pet);
    }

    /**
     * 通过用户id查询宠物信息
     * @param clientId
     * @return
     */
    @Override
    public List<Pet> selectPetByClientId(Integer clientId) {
        return petMapper.selectPetByClientId(clientId);
    }
}
