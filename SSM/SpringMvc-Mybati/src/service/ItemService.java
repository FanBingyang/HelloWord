package service;

import java.util.List;

import pojo.Items;

public interface ItemService {
	
	//查询商品列表
	public List<Items> selectItemsList();
	
	//通过id查询
	public Items selectItemsById(Integer id);
	
	//修改
	public void updateItemsById(Items items);

}
