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
		//���post�ύ��ʽ������������
		//req.setCharacterEncoding("UTF-8");
		
		//�����Լ��İ�װ�࣬���get��post������
		req = new MyRequest(req);//��װrequest
		chain.doFilter(req, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}


/**
 * װ�����ģʽ��
 * 1��ʵ���뱻��װ������ͬ�Ľӿ�
 * 2������һ���뱻��װ����ͬ���������
 * 3������һ�����췽�����ѱ���װ���󴫹���
 * 4�����ڲ���Ҫ��д�ķ�����ֱ�ӵ���
 * 5��������Ҫ��д�ķ�����д�Լ��ķ�����
 */
class MyRequest extends HttpServletRequestWrapper{
	HttpServletRequest request;
	
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

//	@Override
//	public String getParameter(String name) {
//		name = request.getParameter(name);//����
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

	//�����ǣ���ֹ��servlet�е������λ����ϴ�getParameter���������ݱ����ת������µ�����
	private boolean flag = true;
	
	@Override
	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> map = request.getParameterMap();//����
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
