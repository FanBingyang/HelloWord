package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemsMapper;
import pojo.Items;

/**
 * 查询商品信息
 * @author FBY
 *
 */
@Service
public class ItemServiceImpl  implements ItemService{

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	//查询所有
	public List<Items> selectItemsList() {
		return itemsMapper.selectByExample(null);
	}
	//通过id查询
	public Items selectItemsById(Integer id){
		return itemsMapper.selectByPrimaryKey(id);
	}
	//修改
	public void updateItemsById(Items items){
		items.setCreatetime(new Date());
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
}
