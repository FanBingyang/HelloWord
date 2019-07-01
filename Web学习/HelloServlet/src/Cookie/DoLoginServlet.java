package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoLoginServlet
 */
//@WebServlet("/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取表单数据
		String userName = request.getParameter("userNam");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		
		
		Cookie ck = new Cookie("userName",userName);
		ck.setPath("/");
		//处理业务逻辑
		//分发方向
		if("tom".equals(userName)&&"123".equals(pwd))
		{
			if(remember!=null) {
				ck.setMaxAge(Integer.MAX_VALUE);//设置Cookie的保存时间

			}else {
				ck.setMaxAge(0);//删除Cookie
			}
			response.addCookie(ck);//将Cookie写回客户端
			
			out.write("登录成功!");
		}else {
			out.write("登录失败!");
			//设置2s跳转到重新登录
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/LoginServlet");
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
