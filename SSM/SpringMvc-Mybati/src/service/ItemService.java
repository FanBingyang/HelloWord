package service;

import java.util.List;

import pojo.Items;

public interface ItemService {
	
	//��ѯ��Ʒ�б�
	public List<Items> selectItemsList();
	
	//ͨ��id��ѯ
	public Items selectItemsById(Integer id);
	
	//�޸�
	public void updateItemsById(Items items);

}
