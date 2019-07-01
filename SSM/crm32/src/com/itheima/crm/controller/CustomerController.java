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
 * 客户管理
 * @author lx
 *
 */
@Controller
public class CustomerController {

	
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	//注解在成员变量上,这些变量的值都是在resource..properties配置文件中
	@Value("${fromType.code}")
	private String fromTypeCode;
	@Value("${industryType.code}")
	private String industryTypeCode;
	@Value("${levelType.code}")
	private String levelTypeCode;
	
	
	//入口
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo,Model model){
		
		//查询出来页面中查询下拉框中的条件都有哪些，
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		
		//通过四个条件  查询分页对象
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	//去修改页面
	/*
	 * 在方法上注解@ResponseBody
	 * 表示该方法的返回结果直接写入HTTP response body中,
	 * 一般在异步获取数据时使用，在使用@RequestMapping后，返回值通常解析为跳转路径
	 * 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。 */
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody  //
	Customer edit(Integer id){
		return customerService.selectCustomerById(id);
	}
	//修改保存
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String update(Customer customer){
		//修改
		customerService.updateCustomerById(customer);
		//返回字符穿"OK"是因为界面的回调函数接受的字符串OK
		return "OK";
	}
	//删除
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id){
		//删除
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
}
