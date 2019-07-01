package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BookHistory.Book;
import BookHistory.DBUtil;

/**
 * Servlet implementation class ShowAllBooksServet
 */
//@WebServlet("/ShowAllBooksServet_1")
public class ShowAllBooksServlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllBooksServlet_1() {
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
		out.print("本网站有以下图书：<br/>");
		Map<String,Book> books = DBUtil.findAllBooks();
		for (Map.Entry<String, Book> book : books.entrySet()) {
			out.println("<a href='"+request.getContextPath()+"/AddCart?id="+book.getKey()+"''>"+book.getValue().getName()+"<a/><br/>");
			
		}
		out.print("<a href='"+request.getContextPath()+"/ShowCart'>查看购物车</a>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
