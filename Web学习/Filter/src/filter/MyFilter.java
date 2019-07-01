package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{

	public MyFilter() {
		System.out.println("MyFilter实例化了");
	}
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter初始化了");
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter1拦截开始了");
		
		//放行
		chain.doFilter(request, response);
		//******在Filter的doFilter方法中如果没有执行上面那一句，那么资源时不会被访问到的
		
		
//		System.out.println("拦截结束了");
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter销毁了");
		
	}
	
	
	//<filter-mapping>的先后顺序决定了Filter的执行顺序
	
	//xml中的配置信息，注册监听
//	<filter>
//  	<filter-name>MyFilter</filter-name>
//  	<filter-class>filter.MyFilter</filter-class>
//  </filter>
//  <filter-mapping>
//  	<filter-name>MyFilter</filter-name>
//  	<!-- 拦截所有servlet -->
//  	<url-pattern>/*</url-pattern>
//  </filter-mapping>
}
