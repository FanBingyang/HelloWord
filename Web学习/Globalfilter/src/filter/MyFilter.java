package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		//解决post提交方式中文乱码问题
		//req.setCharacterEncoding("UTF-8");
		
		//调用自己的包装类，解决get和post的乱码
		req = new MyRequest(req);//包装request
		chain.doFilter(req, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}


/**
 * 装饰设计模式：
 * 1，实现与被包装对象相同的接口
 * 2，定义一个与被包装类相同对象的引用
 * 3，定义一个构造方法，把被包装对象传过来
 * 4，对于不需要改写的方法，直接调用
 * 5，对于需要改写的方法，写自己的方法体
 */
class MyRequest extends HttpServletRequestWrapper{
	HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

//	@Override
//	public String getParameter(String name) {
//		name = request.getParameter(name);//乱码
//		try {
//			return new String(name.getBytes("ios-8859-1"),"UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public String getParameter(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name)[0];
	}
	
	@Override
	public String[] getParameterValues(String name) {
		Map<String, String[]> map = getParameterMap();
		return map.get(name);
	}

	//定义标记，防止在servlet中调用两次或以上次getParameter，导致数据被多次转码而导致的乱码
	private boolean flag = true;
	
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();//乱码
		if(flag)
		{
			for (Map.Entry<String , String[]> m : map.entrySet()) {
				String[] values = m.getValue();
				for (int i = 0; i < values.length; i++) {
					try {
						values[i] = new String(values[i].getBytes("iso-8859-1"),"UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			flag = false;
		}
		return map;
	}
	
	
	
	
	
	
	
	
}
