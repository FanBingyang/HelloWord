package HttpServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo6
 */
//@WebServlet("/ServletDemo6")
public class ResponseDemo6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("A:��Ҫ��Ǯ");
		System.out.println("B:��û�У������ҿ��Ը�����˭��");
		
//		//���߿ͻ���Ҫ���¶�����Դ
//		response.setStatus(302);
//		//���������Ҫȥ�����ĸ�URL
//		response.setHeader("location", "/HelloServlet/responsedemo1");
		
		//�������¶����൱����������)
		//ע��:��������������,��ַ�����,������ת������Ӧ��,�����ܴ�������
		response.sendRedirect("/HelloServlet/responsedemo1");
		
		System.out.println("A:��ȥ��");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
