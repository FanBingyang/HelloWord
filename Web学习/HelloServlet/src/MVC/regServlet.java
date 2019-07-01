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
		//获取表单数据
		
		UserForm uf = new UserForm();
		try {
			BeanUtils.populate(uf, request.getParameterMap());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!uf.validate()) {//如果map不为空，说明有错误信息
			
			request.setAttribute("uf", uf);
			request.getRequestDispatcher("regMVC.jsp").forward(request, response);
			return;
		}
		
		
		User user = new User();
		try {
		/*	ConvertUtils.register(new Converter() { //注册一个日期转换器

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
			
			//转换时间形式
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.populate(user, request.getParameterMap());
			
			//调用业务逻辑
			UserService us = new UserServletImpl();
			
			//查看用户名已被注册
			us.findUserByName(user.getUsername());
		 		
			us.register(user);
		}catch (UserExistException e) {
			
			request.setAttribute("error","用户名已存在");
			request.getRequestDispatcher("/regMVC.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//分发转向
		response.getWriter().write("注册成功,1秒后跳转到主页");
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
