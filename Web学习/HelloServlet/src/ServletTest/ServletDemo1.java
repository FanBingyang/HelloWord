package ServletTest;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{
	//Servlet�������ڷ���
	//ʵ����
	//��servlet��һ�α�����ʱ������ 
	public ServletDemo1() {
		System.out.println("*********ServletDemo1()ִ����****************");
	}
	
	//Servlet�������ڷ���
	//��ʼ��
	//��servlet��һ�α�����ʱ������ 
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("*********init()ִ����****************");
	}
	
	//Servlet�������ڷ���
	//����
	//ÿ�α�����ʱ������ 
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("hello servlet!");
		System.out.println("*********service()ִ����****************");
	}
	
	//Servlet�������ڷ���
	//����
	//Ӧ��ж��ʱ����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("*********destroy()ִ����****************");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
