package ListenerDemo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//index.jsp����ʱ����
		System.out.println("ServletRequest���󱻴�����");
		
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//index.jsp�������ʱ����
		System.out.println("ServletRequest����������");

	}


}
