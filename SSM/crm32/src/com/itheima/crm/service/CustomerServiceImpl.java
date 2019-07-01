package com.itheima.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.mapper.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/**
 * �ͻ�����
 * 
 * @author lx
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerDao customerDao;
	// ͨ���ĸ����� ��ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		//ÿҳ��
		page.setSize(5);
		vo.setSize(5);
		if (null != vo) {
			// �жϵ�ǰҳ
			if (null != vo.getPage()) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() -1)*vo.getSize());
			}
			if(null != vo.getCustName() && !"".equals(vo.getCustName().trim())){
				vo.setCustName(vo.getCustName().trim());
			}
			if(null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())){
				vo.setCustSource(vo.getCustSource().trim());
			}
			if(null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())){
				vo.setCustIndustry(vo.getCustIndustry().trim());
			}
			if(null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())){
				vo.setCustLevel(vo.getCustLevel().trim());
			}
			//������
			page.setTotal(customerDao.customerCountByQueryVo(vo));
			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
		}
		return page;

	}
	
	//ͨ��ID��ѯ�ͻ�
	public Customer selectCustomerById(Integer id){
		return customerDao.selectCustomerById(id);
	}
	
	//�޸Ŀͻ�ͨ��ID
	public void updateCustomerById(Customer customer){
		customerDao.updateCustomerById(customer);
	}
	
	//ͨ��ID ɾ���ͻ�
	public void deleteCustomerById(Integer id){
		customerDao.deleteCustomerById(id);
	}
}