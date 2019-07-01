package com.zls.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zls.domain.User;
import com.zls.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		//1 获取表单数据
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		System.out.println("username"+username);
		//2 处理业务逻辑
		UserService userService = new UserService();
		User user = userService.ckUser(username,userpass);
		if(user!=null)
		{
			String aoto_login = request.getParameter("aoto_login");
			Cookie cookie = new Cookie("user", username+"&"+userpass);
			cookie.setPath("/");
			if(aoto_login!=null)
			{
				cookie.setMaxAge(60*60*24);
			}
			else{
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			request.getSession().setAttribute("user", user);
			request.setAttribute("username", username);
			request.getRequestDispatcher("/admin/login/home.jsp").forward(request, response);
			
		}
		else {
			//3 分发转向
			request.setAttribute("msg", "用户名或密码错误！请重回请登录");
			request.getRequestDispatcher("/admin/login/Login.jsp").forward(request, response);
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
