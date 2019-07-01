package MVC;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

/**
 * Servlet implementation class regServlet
 */
//@WebServlet("/regServlet")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regServlet() {
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
		//��ȡ������
		
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!uf.validate()) {//���map��Ϊ�գ�˵���д�����Ϣ
			
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("regMVC.jsp").forward(request, response);
			return;
		}
		
		
		User user = new User();
		try {
		/*	ConvertUtils.register(new Converter() { //ע��һ������ת����

				@Override
				public Object convert(Class type, Object value) {
					// TODO Auto-generated method stub
					Date date1 = null;
					if(value instanceof String) {
						String date = (String)value;
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						try {
							date1 = sdf.parse(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return date1;
				}
			}, Date.class);*/
			
			//ת��ʱ����ʽ
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			
			//����ҵ���߼�
			UserService us = new UserServletImpl();
			
			//�鿴�û����ѱ�ע��
			us.findUserByName(user.getUsername());
		 		
			us.register(user);
		}catch (UserExistException e) {
			
			request.setAttribute("error","�û����Ѵ���");
			request.getRequestDispatcher("/regMVC.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//�ַ�ת��
		response.getWriter().write("ע��ɹ�,1�����ת����ҳ");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/loginMVC.jsp");
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
