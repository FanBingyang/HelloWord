package ListenerDemo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//index.jspҳ�汻����ʱ�������ö���
		System.out.println("HttpSession���󴴽���");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
		//������ҳ���ֶ�����
		System.out.println("HttpSession����������");

	}

}
