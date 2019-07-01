package HttpServlet;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class registerDemo
 */
//@WebServlet("/registerDemo")
public class registerDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���߷�����Ҫʹ��ʲô���롣ע�⣺�������ŶҲ�ܹ�����ʲô���봫�����ľ���ʲô����
		//ֻ�ܽ��post���ύ����
		request.setCharacterEncoding("UTF-8");
//		test1(request);
//		test2(request);
//		test3(request); 
		test4(request);
		
	}

	public void test4(HttpServletRequest request) {
		try {
			User u = new User();
			System.out.println("��װ����ǰ��"+u);
			
			//���ù���jar����ķ���ʵ��test3��ʵ�ֵķ������Ҹ������
			BeanUtils.populate(u, request.getParameterMap());
			
			System.out.println("��װ���ݺ�"+u);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test3(HttpServletRequest request) {
		try {
			User u = new User();
			System.out.println("��װ����ǰ��"+u);
			//��ȡ������
			Map<String, String[]> map = request.getParameterMap();
			for (Map.Entry<String, String[]> m:map.entrySet()) {
				String name = m.getKey();
				String[] value=m.getValue();
				
				//����һ������������
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				//�õ�setter����
				Method setter = pd.getWriteMethod();
				
				if(value.length==1) {
					setter.invoke(u, value[0]);//��һ��ֵ�ı�����ֵ
				}
				else {
					setter.invoke(u, (Object)value);//�൱�ڸ���ѡ��ֵ
				}
			}
			System.out.println("��װ���ݺ�"+u);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test2(HttpServletRequest request) {
		//��ȡ���б�name������
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();//�õ�ÿһ��name��
			System.out.println(name);
			System.out.println("---------------");
			String[] values = request.getParameterValues(name);//����name���õ�valueֵ
			for (int i = 0;values!=null && i < values.length; i++) {
				System.out.println(name+":\t"+values[i]);
			}
		}
	}

	public void test1(HttpServletRequest request) {
		//��ȡ������
		//���ݱ���name���Ե�������ȡvalue���Ե�ֵ����
		String[] userName = request.getParameterValues("userName");
		String password = request.getParameter("pwd");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobby");
		String city = request.getParameter("city");
		
		System.out.println(userName[0]);
		System.out.println(password);
		System.out.println(sex);
		
		for(int i=0;hobbys!=null && i<hobbys.length;i++)
		{
			System.out.print(hobbys[i]+"\t");
		}
		System.out.println(city);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
