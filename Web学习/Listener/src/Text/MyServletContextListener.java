package Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//通过事件源对象得到事件源（ServletContext）
		ServletContext application = sce.getServletContext();
		//创建一个集合用与存储所有的session对象               保证线程安全
		final List<HttpSession> list =Collections.synchronizedList( new ArrayList<HttpSession>());
		
		//把集合放到application域中
		application.setAttribute("saession", list);
		
		//创建一个计时器对象
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("开始扫描。。。");
				
				//这种迭代器不能并发修改
			/*	for(HttpSession session:list) {
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l>5000) {//如果时间大于5s，把session销毁
						session.invalidate();//销毁session
						list.remove(session);//从集合中移除
					}
				} */
				
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l>5000) {//如果时间大于5s，把session销毁
						System.out.println("session移除了"+session.getId());
						
						session.invalidate();//销毁session
						iterator.remove();//从集合中移除
					}
					
				}
				
			}
		}, 2000,5000);//延迟2s，2s后执行，间隔5s执行一次
		
		
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
	}

	

}
