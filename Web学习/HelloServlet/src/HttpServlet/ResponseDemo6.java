package HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo6
 */
//@WebServlet("/ServletDemo6")
public class ResponseDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("A:我要借钱");
		System.out.println("B:我没有，但是我可以告诉你谁有");
		
//		//告诉客户端要重新定向资源
//		response.setStatus(302);
//		//告诉浏览器要去访问哪个URL
//		response.setHeader("location", "/HelloServlet/responsedemo1");
		
		//请求重新定向（相当于上面两句)
		//注意:服务器请求两次,地址栏会变,可以跳转到其他应用,但不能传输数据
		response.sendRedirect("/HelloServlet/responsedemo1");
		
		System.out.println("A:我去了");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
