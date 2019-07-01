package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilterConfigTest implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//ͨ��FilterConfig�����ȡ�������ļ��еĳ�ʼ����Ϣ
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);
		request.setCharacterEncoding(encoding);
		
		//����
		chain.doFilter(request, response);
		
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
