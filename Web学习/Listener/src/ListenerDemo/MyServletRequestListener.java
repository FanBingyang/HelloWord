package ListenerDemo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		//index.jsp加载时创建
		System.out.println("ServletRequest对象被创建了");
		
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		//index.jsp加载完毕时销毁
		System.out.println("ServletRequest对象被销毁了");

	}


}
