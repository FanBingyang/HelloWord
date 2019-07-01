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
		
		//MD5加密过后的密码
		password = MD5Utils.md5(password);
		
		UserService us = new UserService();
		User user = us.findUser(username,password);
		
		if(user!=null) {
			String autologin = request.getParameter("autologin");
			Cookie cookie = new Cookie("uesr",user.getUsername()+"&"+user.getPassword());
			cookie.setPath("/");
			if(autologin!=null) {//要把用户信息保存到cookie
				cookie.setMaxAge(60*60*24*7);//7天有效
			}else {//清除cookie对象的数据
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);//把cookie保存到客户端
			
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			
		}else {
			request.setAttribute("msg","用户名或密码错误，请重新登录！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
