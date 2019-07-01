package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {
	
	// ͨ���ĸ����� ��ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo);
	
	//ͨ��ID��ѯ�ͻ�
	public Customer selectCustomerById(Integer id);
	
	//�޸Ŀͻ�ͨ��ID
	public void updateCustomerById(Customer customer);
	
	//ͨ��ID ɾ���ͻ�
	public void deleteCustomerById(Integer id);

}
