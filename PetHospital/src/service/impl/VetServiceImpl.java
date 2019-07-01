package service.impl;

import mapper.VetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Vet;
import service.VetService;

import java.util.List;

@Service
public class VetServiceImpl implements VetService {

    @Autowired
    private VetMapper vetMapper;

    /**
     * 根据id删除医生
     * @param vetId
     * @return
     */
    @Override
    public void deleteVetById(Integer vetId) {
        vetMapper.deleteVetById(vetId);
    }

    /**
     * 根据条件（姓名，专业）查询医生
     * @param vet
     * @return
     */
    @Override
    public List<Vet> selectVetByQuery(Vet vet) {
        return vetMapper.selectVetByQuery(vet);
    }

    /**
     * 添加医生
     * @param record
     * @return
     */
    @Override
    public int insertVet(Vet record) {
        return vetMapper.insertVet(record);
    }

    /**
     * 根据id查询医生
     * @param vetId
     * @return
     */
    @Override
    public Vet selectVetById(Integer vetId) {
        return vetMapper.selectVetById(vetId);
    }

    /**
     * 修改医生信息
     * @param vet
     * @return
     */
    @Override
    public int updateVet(Vet vet) {
        return vetMapper.updateVet(vet);
    }
}
