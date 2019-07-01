package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zls.domain.StoreFile;
import com.zls.service.FileService;

public class AddFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡ����
		StoreFile storefile = (StoreFile) request.getAttribute("storefile");
		String fileType = request.getParameter("fileType");
//		out.println("storefile.getFilename()"+storefile.getFilename());
//		out.println("storefile.getFilesize()"+storefile.getFilesize());
//		out.println("storefile.getFilestyle()"+storefile.getFilestyle());
//		out.println("storefile.getUpdate()"+storefile.getUpdate());
		//����ҵ���߼�service  �������ݿ����
		FileService fileservice = new FileService();
		fileservice.addFile(storefile,fileType);
		
		request.setAttribute("fileType", fileType);
		//��תҳ��
		//request.getRequestDispatcher("fileListServlet").forward(request, response);
		request.getRequestDispatcher("/admin/login/upReminder.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
