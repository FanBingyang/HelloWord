package HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo1
 */
//@WebServlet("/ServletDemo1")
public class ResponseDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������Ĭ�ϵı����ʽ��ISO-8859-1������֧�����ģ�tomcat�涨��
		
//		//���߷�����Ӧʹ��UTF-8�����ı�
//		response.setCharacterEncoding("UTF-8");
//		//���߿ͻ���Ҫ��ʲô�����ʽ
//		response.setHeader("content-type", "text/html;charset=UTF-8");
		
		//���߷�����Ӧʹ��UTF-8�����ı�,���߿ͻ���Ҫ��ʲô�����ʽ
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();//�õ�һ���ַ������
		out.write("��ã�");//��ͻ�����Ӧ�ı�����
			
			
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
