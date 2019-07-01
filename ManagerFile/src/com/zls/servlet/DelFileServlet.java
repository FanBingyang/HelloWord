package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zls.service.FileService;

public class DelFileServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String fileType = request.getParameter("fileType");
		System.out.println("fileType....:"+fileType);
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"),"UTF-8");
		System.out.println("文件名是："+name);
		
		FileService fileservice = new FileService();
		fileservice.deleteFile(name,fileType);
		request.setAttribute("fileType", fileType);
		request.getRequestDispatcher("/admin/login/deleteReminder.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
