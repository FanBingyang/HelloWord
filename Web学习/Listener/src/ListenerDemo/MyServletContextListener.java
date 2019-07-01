package ListenerDemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext对象创建了");
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext对象销毁了");
		
	}


}
