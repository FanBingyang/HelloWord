package Text;
/**
 * 定时销毁session
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
		//得到application对象中的list集合
		ServletContext application = session.getServletContext();
		//得到session对象，并放到list集合中
		List<HttpSession> list = (List<HttpSession>) application.getAttribute("session");
		
		list.add(session);
		System.out.println("添加了"+session.getId());
		
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		

	}

}
