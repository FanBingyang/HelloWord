package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictDao {

	
	//��ѯ��
	public List<BaseDict> selectBaseDictListByCode(String code);
}
