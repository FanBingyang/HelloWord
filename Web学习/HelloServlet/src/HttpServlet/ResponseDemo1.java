package HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo1
 */
//@WebServlet("/ServletDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//服务器中默认的编码格式是ISO-8859-1，它不支持中文，tomcat规定的
		
//		//告诉服务器应使用UTF-8解析文本
//		response.setCharacterEncoding("UTF-8");
//		//告诉客户端要用什么编码格式
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//告诉服务器应使用UTF-8解析文本,告诉客户端要用什么编码格式
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();//得到一个字符输出流
		out.write("你好！");//向客户端响应文本内容
			
			
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
