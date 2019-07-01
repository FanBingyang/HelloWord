package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BookHistory.Book;
import BookHistory.DBUtil;

/**
 * Servlet implementation class addCart
 */
//@WebServlet("/addCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
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
		//根据id得到书
		String id = request.getParameter("id");
		Book book = DBUtil.findBookById(id);
		
		//得到session对象
		HttpSession session = request.getSession();
		//从session中取出list（购物车）
		List<Book> list= (List<Book>) request.getSession().getAttribute("cart");
		if(list==null) {
			list = new ArrayList<Book>();
		}
		list.add(book);
		
		session.setAttribute("cart", list);//吧list放回到session域中
		
		out.print("购买成功!");
		//response.sendRedirect(request.getContextPath()+"/showAllBooksServlet_1");
		response.setHeader("refresh", "2;url="+request.getContextPath()+"/ShowAllBooksServlet_1");
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
