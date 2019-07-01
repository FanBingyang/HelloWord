package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class CookieDemo1
 */
//@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获取客户端保存的最后的访问时间
		Cookie[] cookies = request.getCookies();//获得客户端的所有的Cookie
		for (int i = 0; cookies!=null && i < cookies.length;  i++) {
			if("lastAccessTime".equals(cookies[i].getName()))//判断当前Cookie中的name是否是想要的Cookie
			{
				long l = Long.parseLong(cookies[i].getValue());//如果是想要的Cookie,则吧Cookie中的Value取出
				out.write("你的最后访问时间是:"+new Date(l).toLocaleString());//yyyy-MM-dd
				
			}
		}
		//在显示上次访问时间的后面添加clear字样
		out.print("<a href='"+request.getContextPath()+"'>clear</a>");
		
		
		//创建cookie,
		Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//Cookie默认是浏览器退出时删除,此时maxAge的默认值是-1,如果设置maxAge为0时,则不保存Cokie
		//此处创建是吧该Cookie保存到磁盘中,浏览器关闭也能保存,如果在有效时间内,下次访问依然生效
		//设置Cookie的有效时间,单位是秒
		ck.setMaxAge(60*5);//保存时间为5min,
		
		//Cookie的path就是当前应用程序的访问路径
		//当前当问路径如果是以Cokie的path开头的路径,浏览器就带,否则就不带
		//设置Cookie的Path,一下三句效果相同
//		ck.setPath("/HelloServlet");
//		 ck.setPath(request.getContextPath());
//		ck.setPath("/");
		
		//并把信息写回到客户端
		response.addCookie(ck);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
