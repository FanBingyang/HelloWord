package service;

import pojo.Vet;

import java.util.List;

public interface VetService {
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
