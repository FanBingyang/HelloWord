package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemsMapper;
import pojo.Items;

/**
 * ��ѯ��Ʒ��Ϣ
 * @author FBY
 *
 */
@Service
public class ItemServiceImpl  implements ItemService{

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	//��ѯ����
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExample(null);
	}
	//ͨ��id��ѯ
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	//�޸�
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
