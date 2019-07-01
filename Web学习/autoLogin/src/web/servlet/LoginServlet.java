package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import util.MD5Utils;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//MD5���ܹ��������
		password = MD5Utils.md5(password);
		
		UserService us = new UserService();
		User user = us.findUser(username,password);
		
		if(user!=null) {
			String autologin = request.getParameter("autologin");
			Cookie cookie = new Cookie("uesr",user.getUsername()+"&"+user.getPassword());
			cookie.setPath("/");
			if(autologin!=null) {//Ҫ���û���Ϣ���浽cookie
				cookie.setMaxAge(60*60*24*7);//7����Ч
			}else {//���cookie���������
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);//��cookie���浽�ͻ���
			
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg","�û�����������������µ�¼��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
