package com.itheima.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

public class FindBookByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		BookServiceImpl bs = new BookServiceImpl();
		Book book = bs.findBookById(id);
		
		request.setAttribute("book", book);
		request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
