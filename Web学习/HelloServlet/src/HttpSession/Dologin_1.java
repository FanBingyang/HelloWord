package HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * Servlet implementation class Dologin_1
 */
//@WebServlet("/Dologin_1")
public class Dologin_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dologin_1() {
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
		PrintWriter out = response.getWriter();
		//��ȡ��������
		String userName = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String code = request.getParameter("code");
//		System.out.println("code"+code);
		String scode = (String)request.getSession().getAttribute("scode");
//		System.out.println("222"+scode);
		
		//����ҵ���߼�
		if("tom".equals(userName)&&"123".equals(pwd))
		{
			//�ַ�ת��
			//equalsIgnoreCase���Դ�Сд
//			System.out.println("code"+code);
//			System.out.println("333"+scode);
			if(!code.equalsIgnoreCase(scode)) {
				request.setAttribute("msg", "��֤�����");
				request.getRequestDispatcher("/Dologin1.jsp").forward(request, response);
			}
			out.print("��¼�ɹ���");
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
