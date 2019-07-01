package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zls.domain.StoreFile;
import com.zls.service.FileService;

public class FileListServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("111111111");
		String fileType = request.getParameter("fileType");
		System.out.println("FileList......:"+fileType);
		FileService fileservice = new FileService();
		List<StoreFile> list = null;
		
		list = fileservice.findAllFile(fileType);

		HttpSession session = request.getSession();
		session.setAttribute("list",list);
		request.setAttribute("files", list);
//		System.out.println("list..."+list);
//		System.out.println("--------------------------------------------");
//		System.out.println("list.get(0)"+list.get(0).getFileid());
//		System.out.println("list.get(1)"+list.get(1).getFileid());
//		System.out.println("list.get(2)"+list.get(2).getFileid());
//		System.out.println("list.get(3)"+list.get(3).getFileid());
//		System.out.println("--------------------------------------------");
//		System.out.println("list.size()"+list.size());
		if(fileType.equals("storeFile")){
	        System.out.println("进入全部文件页面");
			request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
		}
		if(fileType.equals("calcuFile")){
			System.out.println("跳转到calcu页面");
			request.getRequestDispatcher("/admin/products/calcuFileList.jsp").forward(request, response);
		}
		if(fileType.equals("blueFile"))
		{
			System.out.println("跳转到blue页面");
			request.getRequestDispatcher("/admin/products/blueFileList.jsp").forward(request, response);
		}
		if(fileType.equals("null")){
			
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
