package HelloJSPServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doLogin
 */
//@WebServlet("/doLogin")
public class doLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ��������
				String userName=request.getParameter("userName");
				String pwd=request.getParameter("pwd");
				
				//����ҵ���߼�
				if("tom".equals(userName) && "123".equals(pwd)){
					request.getSession().setAttribute("name",userName);
					//ת��
					request.getRequestDispatcher("/HelloJSP/success.jsp").forward(request, response);
					
				}else{
					//�ض���
//					response.sendRedirect(request.getContextPath()+"/HelloJSP/login1.jsp");
					request.setAttribute("msg", "�û�����������������µ�¼��");
					request.getRequestDispatcher("/HelloJSP/login1.jsp").forward(request, response);
				}
				
				
				//�ַ�ת��
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
