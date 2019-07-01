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
		//ͨ���¼�Դ����õ��¼�Դ��ServletContext��
		ServletContext application = sce.getServletContext();
		//����һ����������洢���е�session����               ��֤�̰߳�ȫ
		final List<HttpSession> list =Collections.synchronizedList( new ArrayList<HttpSession>());
		
		//�Ѽ��Ϸŵ�application����
		application.setAttribute("saession", list);
		
		//����һ����ʱ������
		Timer t = new Timer();
		
		t.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("��ʼɨ�衣����");
				
				//���ֵ��������ܲ����޸�
			/*	for(HttpSession session:list) {
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l>5000) {//���ʱ�����5s����session����
						session.invalidate();//����session
						list.remove(session);//�Ӽ������Ƴ�
					}
				} */
				
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					HttpSession session = (HttpSession) iterator.next();
					
					long l = System.currentTimeMillis()-session.getLastAccessedTime();
					if(l>5000) {//���ʱ�����5s����session����
						System.out.println("session�Ƴ���"+session.getId());
						
						session.invalidate();//����session
						iterator.remove();//�Ӽ������Ƴ�
					}
					
				}
				
			}
		}, 2000,5000);//�ӳ�2s��2s��ִ�У����5sִ��һ��
		
		
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
	}

	

}
