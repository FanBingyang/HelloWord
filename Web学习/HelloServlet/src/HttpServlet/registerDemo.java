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
		//告诉服务器要使用什么编码。注意：浏览器是哦也能够的是什么编码传过来的就是什么编码
		//只能解决post的提交方法
		request.setCharacterEncoding("UTF-8");
//		test1(request);
//		test2(request);
//		test3(request); 
		test4(request);
		
	}

	public void test4(HttpServletRequest request) {
		try {
			User u = new User();
			System.out.println("封装数据前："+u);
			
			//利用工具jar包里的方法实现test3所实现的方法，且更简便快捷
			BeanUtils.populate(u, request.getParameterMap());
			
			System.out.println("封装数据后："+u);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test3(HttpServletRequest request) {
		try {
			User u = new User();
			System.out.println("封装数据前："+u);
			//获取表单数据
			Map<String, String[]> map = request.getParameterMap();
			for (Map.Entry<String, String[]> m:map.entrySet()) {
				String name = m.getKey();
				String[] value=m.getValue();
				
				//创建一个属性描述器
				PropertyDescriptor pd = new PropertyDescriptor(name, User.class);
				//得到setter属性
				Method setter = pd.getWriteMethod();
				
				if(value.length==1) {
					setter.invoke(u, value[0]);//给一个值的变量赋值
				}
				else {
					setter.invoke(u, (Object)value);//相当于给复选框赋值
				}
			}
			System.out.println("封装数据后："+u);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test2(HttpServletRequest request) {
		//获取所有表单name的名字
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			String name = (String)names.nextElement();//得到每一个name名
			System.out.println(name);
			System.out.println("---------------");
			String[] values = request.getParameterValues(name);//根据name名得到value值
			for (int i = 0;values!=null && i < values.length; i++) {
				System.out.println(name+":\t"+values[i]);
			}
		}
	}

	public void test1(HttpServletRequest request) {
		//获取表单数据
		//根据表单中name属性的名，获取value属性的值方法
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
