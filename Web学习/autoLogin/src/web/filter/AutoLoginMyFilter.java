package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

public class AutoLoginMyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1, 转换两个对象，HttpServletRequest,HttpServletResponse
		HttpServletRequest req = (HttpServletRequest)request ;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String uri = req.getRequestURI();//  /autoLogin/login.jsp
		String path = req.getContextPath();//  /autoLogin
		path = uri.substring(path.length());//  /login.jsp
		
		if(!("/login.jsp".equals(path) || "/loginServlet".equals(path))) {
			User user = (User)req.getSession().getAttribute("user");
			//如果用户没有登录过，我们才执行自动登陆
			if(user==null) {
				//2，处理业务
				//得到cookies
				Cookie[] cookies = req.getCookies();
				String username ="";
				String password = "";
				//从数组中找到想要的user对象信息
				for (int i = 0; i < cookies.length && cookies!=null; i++) {
					if("user".equals(cookies[i].getName())) {
						String value = cookies[i].getValue();//tom&123
						String[] values = value.split("&");
						username = values[0];
						password = values[1];
					}
				}
				
				
				//登录操作
				UserService us = new UserService();
				User u = us.findUser(username, password);
				//如果登录成功,把用户信息存到session中
				if(u!=null) {
					req.getSession().setAttribute("user", u);
				}
			}
		}
		//3,放行
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
