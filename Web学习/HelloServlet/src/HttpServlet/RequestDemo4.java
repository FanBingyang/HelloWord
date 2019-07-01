package HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestDemo5
 */
//@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo4() {
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
		
		//
		String str = "abcdefg";
		System.out.println("A:�������");
		System.out.println("B:�Ұ첻��,���ҿ������˰����");
		//���Ǳ���������ӵ�request������
		request.setAttribute("s", str);
		//������ת����ָ��url��
		//ע��:����ת��������ת������Ӧ��
		request.getRequestDispatcher("/HelloServlet/requestDemo5").forward(request, response);
		System.out.println("���������");
		
		
		//�������,��������Դ����һ����Դ��
//		request.getRequestDispatcher("/HelloServlet/requestDemo5").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
