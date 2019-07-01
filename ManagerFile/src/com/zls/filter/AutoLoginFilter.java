package com.zls.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.Filter.Chain;
import com.zls.domain.User;
import com.zls.service.UserService;

public class AutoLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器初始化");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//1 转换两个对象HttpServletReqeust，HttpServletResponse
		  HttpServletRequest request = (HttpServletRequest) req;
		  HttpServletResponse response = (HttpServletResponse) res;
		  String uri = request.getRequestURI();//ManagerFile/login.jsp
		  String path = request.getContextPath();//ManagerFile
		  path = uri.substring(path.length());//login.jsp
		
		 
		  if(!("/login.jsp".equals("path")||"/loginServlet".equals(path)))
		  {
			  User user= (User) request.getSession().getAttribute("user");
			//如果session得到了user对象，说明已经登录过或自动登录过。
			//那么请求下一个资源时就不用执行自动登录了
			//用户没有登录过，我们才执行自动登录 
			  if (user == null) {
					System.out.println("aaaaaaaaaaaaaaa");
					// 2、处理业务
					// 得到cookies数组
					Cookie[] cookies = request.getCookies();
					String username = "";
					String password = "";
					// 从数组中找到想要的user对象的信息
					for (int i = 0; cookies != null && i < cookies.length; i++) { 
						if ("user".equals(cookies[i].getName())) {
							String value = cookies[i].getValue();// tom&123
							String[] values = value.split("&");
							username = values[0];
							password = values[1];
						}
					}  
//					System.out.println("----------------------------------");
//					System.out.println("username="+username);
//					System.out.println("password="+password);
//					System.out.println("uri="+uri);
//					System.out.println("path"+request.getContextPath());
//					System.out.println("path2"+path);
//					System.out.println("----------------------------------");
					// 登录操作
					UserService us = new UserService();
					User u = us.ckUser(username, password);
					// 如果登录成功，把用户信息存到session中
					if (u != null) {
						request.getSession().setAttribute("user", u);
					}
		  }
		  		
	}
		//3 放行
		chain.doFilter(request, response);
}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁");
	}


}
