package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.out.println("方法前1");
		
		//判断用户是否登录，如果没有登录，重定向到登录页面，不放行，如果登陆了就放行
		//URL  http://localhost:8080/aaa/bbb/xxx.action
		//URI  /xxx.action
		//获取到请的URI
		String requestURI = request.getRequestURI();
		//判断请求URI中是否包含要拦截的页面.不包含证明不是登录页面的请求，进一步判断
		if(!requestURI.contains("/login")){
			//拿到session中是否有用户名
			String username = (String)request.getSession().getAttribute("USER_SESSION");
			//如果用户名为空，则没有登录，跳转到登录页面，不放行
			if(username == null){
				response.sendRedirect(request.getContextPath()+"/login.action");
				return false;
			}
		}
		//如果请求页面是登录页面，放行
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("方法后1");
		
	}


	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("视图渲染后1");
		
	}
}
