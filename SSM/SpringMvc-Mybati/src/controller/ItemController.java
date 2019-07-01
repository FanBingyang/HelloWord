package controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pojo.Items;
import pojo.QueryVo;
import service.ItemService;


/**
 * 商品管理
 * @author FBY
 *
 */ 
//添加注解
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	//入门程序  第一   返回Handler 包名 + 类名 + 方法名
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList(){
		
		//从mysql中查询
		List<Items> list = itemService.selectItemsList();
				
		
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("itemList", list);
		//手动写完整jsp页面路径
//		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		//在springmvc.xml中，配置视图解析器，可以设置路径和后缀名，所以在这可以直接写jsp页面名称，通过自动拼接完成
		mav.setViewName("itemList");
		return mav;
	}
	
	//跳转 修改 页面  入参id
	@RequestMapping(value = "itemEdit.action")
	
//	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
	
	public ModelAndView toEdit(Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		//Servlet原始开发
//		int id1 = Integer.parseInt(request.getParameter("id"));
		//查询一个商品
//		Items items = itemService.selectItemsById(id1);
		
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		//数据
		mav.addObject("item",items);
		mav.setViewName("editItem");
		return mav;
		
	}
	
	//提交修改页面  入参 为Items对象
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateitem(Items items){
		
		//修改
		itemService.updateItemsById(items);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
		
	}
	
	
	//提交修改页面  入参 为QueryVo对象
		@RequestMapping(value = "/updateitem2.action")
		public ModelAndView updateitem(QueryVo vo){
			
			//修改
			itemService.updateItemsById(vo.getItems());
			
			//用方法需要将前端页面获取值的el表达式改成items.属性名
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
			
		}
	
	
	
	
	
}
