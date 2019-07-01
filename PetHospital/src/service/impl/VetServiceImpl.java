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
     * ����idɾ��ҽ��
     * @param vetId
     * @return
     */
    @Override
    public void deleteVetById(Integer vetId) {
        vetMapper.deleteVetById(vetId);
    }

    /**
     * ����������������רҵ����ѯҽ��
     * @param vet
     * @return
     */
    @Override
    public List<Vet> selectVetByQuery(Vet vet) {
        return vetMapper.selectVetByQuery(vet);
    }

    /**
     * ���ҽ��
     * @param record
     * @return
     */
    @Override
    public int insertVet(Vet record) {
        return vetMapper.insertVet(record);
    }

    /**
     * ����id��ѯҽ��
     * @param vetId
     * @return
     */
    @Override
    public Vet selectVetById(Integer vetId) {
        return vetMapper.selectVetById(vetId);
    }

    /**
     * �޸�ҽ����Ϣ
     * @param vet
     * @return
     */
    @Override
    public int updateVet(Vet vet) {
        return vetMapper.updateVet(vet);
    }
}
