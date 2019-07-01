package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

/**
 * �ͻ�����
 * @author lx
 *
 */
@Controller
public class CustomerController {

	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	//ע���ڳ�Ա������,��Щ������ֵ������resource..properties�����ļ���
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	
	//���
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model){
		
		//��ѯ����ҳ���в�ѯ�������е�����������Щ��
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		
		//ͨ���ĸ�����  ��ѯ��ҳ����
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	//ȥ�޸�ҳ��
	/*
	 * �ڷ�����ע��@ResponseBody
	 * ��ʾ�÷����ķ��ؽ��ֱ��д��HTTP response body��,
	 * һ�����첽��ȡ����ʱʹ�ã���ʹ��@RequestMapping�󣬷���ֵͨ������Ϊ��ת·��
	 * ����@responsebody�󷵻ؽ�����ᱻ����Ϊ��ת·��������ֱ��д��HTTP response body�С� */
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody  //
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}
	//�޸ı���
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		//�޸�
		customerService.updateCustomerById(customer);
		//�����ַ���"OK"����Ϊ����Ļص��������ܵ��ַ���OK
		return "OK";
	}
	//ɾ��
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		//ɾ��
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
}
