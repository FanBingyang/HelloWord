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
		System.out.println("MyFilterʵ������");
	}
	
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("MyFilter��ʼ����");
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter1���ؿ�ʼ��");
		
		//����
		chain.doFilter(request, response);
		//******��Filter��doFilter���������û��ִ��������һ�䣬��ô��Դʱ���ᱻ���ʵ���
		
		
//		System.out.println("���ؽ�����");
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter������");
		
	}
	
	
	//<filter-mapping>���Ⱥ�˳�������Filter��ִ��˳��
	
	//xml�е�������Ϣ��ע�����
//	<filter>
//  	<filter-name>MyFilter</filter-name>
//  	<filter-class>filter.MyFilter</filter-class>
//  </filter>
//  <filter-mapping>
//  	<filter-name>MyFilter</filter-name>
//  	<!-- ��������servlet -->
//  	<url-pattern>/*</url-pattern>
//  </filter-mapping>
}
