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
		out.print("���ﳵ��������Ʒ��<br/>");
		
		//�õ�session����
		HttpSession session = request.getSession();
		List<Book> books = (List<Book>)session.getAttribute("cart");
		if(books==null) {
			out.print("�㻹ʲô��û��");
			//response.sendRedirect(request.getContextPath()+"/ShowAllBooksServlet_1");
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/ShowAllBooksServlet_1");
			return ;
		}
		for (Book book : books) {
			out.write(book.getName()+"<br/>");
		}
		
		//����session�Ĵ��ʱ�䣬��λ��
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
