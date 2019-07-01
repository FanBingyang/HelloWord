package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictService {

	
	//²éÑ¯¯¢
	public List<BaseDict> selectBaseDictListByCode(String code);
}
