package MVC;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class LoginServletMVC
 */
//@WebServlet("/LoginServletMVC")
public class LoginServletMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletMVC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		

		try {
			BeanUtils.populate(user, request.getParameterMap());

			UserService us = new UserServletImpl();
			
			User u;
				u = us.login(user);
			
				//�ַ�ת��
				if(u!=null) {
					request.setAttribute("u", user);//�����½�ɹ��Ͱ�user����ŵ�session������
					request.getRequestDispatcher("/loginMVC.jsp").forward(request, response);
				}else {
					//��¼ʧ�ܷ��ص�½����
					response.sendRedirect(request.getContextPath()+"/loginMVC_1.jsp");
					
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//�������Զ����쳣����������ʧ���ˡ�������
		/*	try {
				BeanUtils.populate(user, request.getParameterMap());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			UserService us = new UserServletImpl();
			
			User u;
			try {
				u = us.login(user);
			
				//�ַ�ת��
				if(u!=null) {
					request.setAttribute("u", user);//�����½�ɹ��Ͱ�user����ŵ�session������
					request.getRequestDispatcher("/loginMVC.jsp").forward(request, response);
					
				}
			} catch (UsersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//��¼ʧ�ܷ��ص�½����
				request.setAttribute("msg",e.getMessage());
//				response.sendRedirect(request.getContextPath()+"/loginMVC_1.jsp");
				request.getRequestDispatcher("loginMVC_1.jsp").forward(request, response);
			} */
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
