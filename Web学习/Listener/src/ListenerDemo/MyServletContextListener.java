package ListenerDemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener{

	
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext���󴴽���");
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext����������");
		
	}


}
