package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zls.domain.User;
import com.zls.service.UserService;

public class RegistUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String userpass1 = request.getParameter("userpass1");
		String userpass2 = request.getParameter("userpass2");
		String useremail = request.getParameter("useremail");
		if(username==null||useremail==null||userpass1==null||userpass2==null)
		{
			request.setAttribute("msg", "ƒ˙ ‰»Î”–ŒÛ");
			request.getRequestDispatcher("/admin/login/regist.jsp").forward(request, response);
		}
		System.out.println("----------------------------------------------");
		System.out.println("username="+username+"userpass1="+userpass1+"useremail"+useremail);
		System.out.println("----------------------------------------------");
		User user = new User();
		user.setUsername(username);
		user.setUserpass(userpass1);
		user.setUseremail(useremail);
		UserService userService = new UserService();
		userService.addUser(user);
		request.getRequestDispatcher("/admin/login/registReminder.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
