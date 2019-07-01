package BookHistory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAllBooksServlet
 */
//@WebServlet("/ShowAllBooksServlet")
public class ShowAllBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("本网站有以下图书:<br/>");
		Map<String, Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.write("<a href='"+request.getContextPath()+"/showBookDetail?id="+book.getKey()+"'target='_blank'>"+book.getValue().getName()+"<a/><br/>");
			
			
		}
		
		
		
		
	
		out.write("你最近浏览过的书有:<br/>");
		Cookie[] cookies = request.getCookies();
		for (int i = 0;cookies!=null && i < cookies.length; i++) {
			if("historyBookId".equals(cookies[i].getName())) {//判断是否有historyBookId的cookie
				
				String value = cookies[i].getValue();//1-2-3
				String[] ids = value.split("-");
				for (int j = 0; j < ids.length; j++) {
					Book book = DBUtil.findBookById(ids[j]);//根据id得到指定的书
					out.print(book.getName()+"<br/>");
				}
				
			}
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
