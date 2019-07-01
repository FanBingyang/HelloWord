package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zls.domain.StoreFile;
import com.zls.service.FileService;

public class ByTimeSortServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		List<StoreFile> list = (List<StoreFile>) session.getAttribute("list");
//		System.out.println("----------------------------------------------");
//		System.out.println("list.get(0)"+list.get(0).getFileid());
//		System.out.println("list.get(1)"+list.get(1).getFileid());
//		System.out.println("list.get(2)"+list.get(2).getFileid());
//		System.out.println("list.get(3)"+list.get(3).getFileid());
//		System.out.println("----------------------------------------------");
//		FileService fileservice = new FileService();
//		List<StoreFile> list = fileservice.findAllFile();
		//利用list的倒序排列
		Collections.reverse(list);
		//排序的一种思路
//		int size = list.size();
//		int a[] = new int[size];
//		for(int i=0;i<6;i++){
//			a[i]=Integer.parseInt(list.get(i).getFileid());
//		}
		request.setAttribute("files", list);
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
