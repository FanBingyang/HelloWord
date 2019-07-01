package ListenerDemo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//index.jsp页面被访问时，创建该对象
		System.out.println("HttpSession对象创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		//销毁在页面手动销毁
		System.out.println("HttpSession对象销毁了");

	}

}
