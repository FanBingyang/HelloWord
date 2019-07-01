package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;
import com.itheima.util.UUIDUtil;

public class AddBookServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取表单数据
		Book book = new Book();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			book.setId(UUIDUtil.getUUID());//手动生成一个随机ID
		} catch (Exception e) {
			e.printStackTrace();
		}
		//调用业务逻辑
		BookServiceImpl bs = new BookServiceImpl();
		bs.addBook(book);
		
		//分发转向
								//不写/代表相对路径，相对于本类的路径
		request.getRequestDispatcher("bookListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
