package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zls.domain.StoreFile;
import com.zls.service.FileService;

public class SearchFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//��ȡ������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String filename=request.getParameter("filename");
		filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
		System.out.println("SearchFileServlet�е�filename="+filename);
		//����ҵ���߼�
		FileService storefile = new FileService();
		List<StoreFile> list = storefile.findFile(filename);
		
		request.setAttribute("files", list);
		//�ַ�ת��
		request.getRequestDispatcher("/admin/products/list.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
