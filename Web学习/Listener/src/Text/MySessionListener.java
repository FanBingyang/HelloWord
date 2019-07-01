package Text;
/**
 * ��ʱ����session
 */
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		//�õ�application�����е�list����
		ServletContext application = session.getServletContext();
		//�õ�session���󣬲��ŵ�list������
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("session");
		
		list.add(session);
		System.out.println("�����"+session.getId());
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		

	}

}
