package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookHistory.Book;

/**
 * Servlet implementation class showCart
 */
//@WebServlet("/showCart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
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
		out.print("购物车有以下商品：<br/>");
		
		//得到session对象
		HttpSession session = request.getSession();
		List<Book> books = (List<Book>)session.getAttribute("cart");
		if(books==null) {
			out.print("你还什么都没买");
			//response.sendRedirect(request.getContextPath()+"/ShowAllBooksServlet_1");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/ShowAllBooksServlet_1");
			return ;
		}
		for (Book book : books) {
			out.write(book.getName()+"<br/>");
		}
		
		//设置session的存活时间，单位秒
//		session.setMaxInactiveInterval(10);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
