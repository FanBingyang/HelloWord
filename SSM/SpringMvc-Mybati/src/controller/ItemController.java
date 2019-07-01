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
 * ��Ʒ����
 * @author FBY
 *
 */ 
//���ע��
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	//���ų���  ��һ   ����Handler ���� + ���� + ������
	@RequestMapping(value = "/item/itemlist.action")
	public ModelAndView itemList(){
		
		//��mysql�в�ѯ
		List<Items> list = itemService.selectItemsList();
				
		
		ModelAndView mav = new ModelAndView();
		//����
		mav.addObject("itemList", list);
		//�ֶ�д����jspҳ��·��
//		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		//��springmvc.xml�У�������ͼ����������������·���ͺ�׺���������������ֱ��дjspҳ�����ƣ�ͨ���Զ�ƴ�����
		mav.setViewName("itemList");
		return mav;
	}
	
	//��ת �޸� ҳ��  ���id
	@RequestMapping(value = "itemEdit.action")
	
//	public ModelAndView toEdit(@RequestParam(value = "id",required = false,defaultValue = "1") Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
	
	public ModelAndView toEdit(Integer id,HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		//Servletԭʼ����
//		int id1 = Integer.parseInt(request.getParameter("id"));
		//��ѯһ����Ʒ
//		Items items = itemService.selectItemsById(id1);
		
		Items items = itemService.selectItemsById(id);
		ModelAndView mav = new ModelAndView();
		//����
		mav.addObject("item",items);
		mav.setViewName("editItem");
		return mav;
		
	}
	
	//�ύ�޸�ҳ��  ��� ΪItems����
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateitem(Items items){
		
		//�޸�
		itemService.updateItemsById(items);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
		
	}
	
	
	//�ύ�޸�ҳ��  ��� ΪQueryVo����
		@RequestMapping(value = "/updateitem2.action")
		public ModelAndView updateitem(QueryVo vo){
			
			//�޸�
			itemService.updateItemsById(vo.getItems());
			
			//�÷�����Ҫ��ǰ��ҳ���ȡֵ��el���ʽ�ĳ�items.������
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("success");
			return mav;
			
		}
	
	
	
	
	
}
