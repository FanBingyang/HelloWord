package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Book;
import com.itheima.service.BookServiceImpl;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SearchBookAJAXServlet
 */
@WebServlet("/searchBookAJAXServlet")
public class SearchBookAJAXServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//只能解决post提交方式的乱码
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
//		System.out.println(name);
		BookServiceImpl bs = new BookServiceImpl();
		
		List<Object> list = bs.searchBookByName(name);
		
		//把集合中的数据转换为字符串返回到网页
//		String  str="[";
//		for (int i = 0; i < list.size(); i++) {
//			if(i>0) {
//				str+=",";
//			}
//			str+="\""+list.get(i)+"\"";
//		}
//		str+="]";
		//最后str为["1001","1002","1003"]
		
		//调用JSON对象，可以将集合中的数据封装成数组
		String str = JSONArray.fromObject(list).toString();
		//最后str为["1001","1002","1003"]
		
		System.out.print(str);//输出到页面查看
		//把数据响应到客户端
		response.getWriter().write(str);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
