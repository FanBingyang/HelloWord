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

public class EditFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String fileid = request.getParameter("id");
	    fileid = new String(fileid.getBytes("iso-8859-1"),"UTF-8");
	    FileService fileservice = new FileService();
	    List<StoreFile> list = fileservice.findFileById(fileid);
		System.out.println("---------------EditFileServlet------------");
		System.out.println("list.get(0).getfileid()"+list.get(0).getFileid());
		request.setAttribute("file", list);
		
		request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
			this.doGet(request, response);
	}

}
