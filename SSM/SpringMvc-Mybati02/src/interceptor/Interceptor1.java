package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.out.println("����ǰ1");
		
		//�ж��û��Ƿ��¼�����û�е�¼���ض��򵽵�¼ҳ�棬�����У������½�˾ͷ���
		//URL  http://localhost:8080/aaa/bbb/xxx.action
		//URI  /xxx.action
		//��ȡ�����URI
		String requestURI = request.getRequestURI();
		//�ж�����URI���Ƿ����Ҫ���ص�ҳ��.������֤�����ǵ�¼ҳ������󣬽�һ���ж�
		if(!requestURI.contains("/login")){
			//�õ�session���Ƿ����û���
			String username = (String)request.getSession().getAttribute("USER_SESSION");
			//����û���Ϊ�գ���û�е�¼����ת����¼ҳ�棬������
			if(username == null){
				response.sendRedirect(request.getContextPath()+"/login.action");
				return false;
			}
		}
		//�������ҳ���ǵ�¼ҳ�棬����
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("������1");
		
	}


	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("��ͼ��Ⱦ��1");
		
	}
}
