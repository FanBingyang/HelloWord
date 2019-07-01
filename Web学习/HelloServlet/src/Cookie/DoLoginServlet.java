package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoLoginServlet
 */
//@WebServlet("/DoLoginServlet")
public class DoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLoginServlet() {
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
		//��ȡ������
		String userName = request.getParameter("userNam");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		
		
		Cookie ck = new Cookie("userName",userName);
		ck.setPath("/");
		//����ҵ���߼�
		//�ַ�����
		if("tom".equals(userName)&&"123".equals(pwd))
		{
			if(remember!=null) {
				ck.setMaxAge(Integer.MAX_VALUE);//����Cookie�ı���ʱ��

			}else {
				ck.setMaxAge(0);//ɾ��Cookie
			}
			response.addCookie(ck);//��Cookieд�ؿͻ���
			
			out.write("��¼�ɹ�!");
		}else {
			out.write("��¼ʧ��!");
			//����2s��ת�����µ�¼
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/LoginServlet");
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
