package HttpServlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo2
 */
//@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		test1(request);
//		test2(request);
//		test3(request);
	}

	public void test3(HttpServletRequest request) {
		Enumeration headers = request.getHeaders("accept-language");
		while(headers.hasMoreElements()) {
			String e = (String)headers.nextElement();
			System.out.println(e+":"+request.getHeader(e));
		}
	}

	public void test2(HttpServletRequest request) {
		//获得所有请求消息头的name
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()) {
			String e = (String)names.nextElement();
			System.out.println(e+":"+request.getHeader(e));
		}
	}

	public void test1(HttpServletRequest request) {
		//获得请求消息头的信息
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		if(header.toLowerCase().contains("mise"))
		{
			System.out.println("你使用的是IE浏览器");
		}
		else if(header.toLowerCase().contains("firefox"))
		{
			System.out.println("你使用的是火狐浏览器");
		}
		else if(header.toLowerCase().contains("chrome"))
		{
			System.out.println("你使用的是谷歌浏览器");
		}
		else {
			System.out.println("你使用的是其他浏览器");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
