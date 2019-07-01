package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Pet;

public interface PetMapper {

    //通过id删除宠物信息
    void deletePetById(Integer petId);

    //根据用户id删除宠物
    void deletePetByClientId(Integer clientId);

    //添加宠物信息
    int insertPet(Pet pet);

    //通过id查询宠物信息
    Pet selectPetById(Integer petId);

    //根据条件(姓名，种类)查询宠物信息
    List<Pet> selectPetByQuery(Pet pet);

    //查询所有宠物
//    List<Pet> selectPetsAll();

    //修改宠物信息
    int updatePetById(Pet pet);

    //通过用户id查询宠物
    List<Pet> selectPetByClientId(Integer clientId);
}