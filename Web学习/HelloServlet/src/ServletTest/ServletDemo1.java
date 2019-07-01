package ServletTest;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletDemo1 implements Servlet{
	//Servlet生命周期方法
	//实例化
	//再servlet第一次被访问时被调用 
	public ServletDemo1() {
		System.out.println("*********ServletDemo1()执行了****************");
	}
	
	//Servlet生命周期方法
	//初始化
	//再servlet第一次被访问时被调用 
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("*********init()执行了****************");
	}
	
	//Servlet生命周期方法
	//服务
	//每次被访问时被调用 
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("hello servlet!");
		System.out.println("*********service()执行了****************");
	}
	
	//Servlet生命周期方法
	//销毁
	//应用卸载时调用
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("*********destroy()执行了****************");
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
