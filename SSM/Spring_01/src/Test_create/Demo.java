package Test_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class Demo {
	@Test
	/*������ʽ1���ղι��죨�ص����գ�*/
	public void fun1() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user");
		
		User user1 = (User)ac.getBean("user");
		User user2 = (User)ac.getBean("user");

		//3.��ӡuser����
		System.out.println(user);
	}
	
	@Test
	/*������ʽ2����̬�������˽⼴�ɣ�*/
	public void fun2() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user2");
		//3.��ӡuser����
		System.out.println(user);
	}
	
	@Test
	/*������ʽ3��ʵ���������˽⼴�ɣ�*/
	public void fun3() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user3");
		//3.��ӡuser����
		System.out.println(user);
	}
	
	@Test
	/* ���� scope��singleton��Ĭ�ϣ���һ��ѡ��Ĭ�ϵĵ�������
	 * ���� scope��prototype��ֻ��������struts2ʱ��ActionBean��������Ϊ������
	 * */
	public void fun4() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user");
		
		User user1 = (User)ac.getBean("user");
		User user2 = (User)ac.getBean("user");

		//3.��ӡuser����
		System.out.println(user);
		
		//�������������ó����ĵĶ��������ͬһ��������true
		//����ÿ�δ��������ó����ĵĶ��������´������µĶ��󣬷���false
		System.out.println(user1==user2); //true
	}
	
	@Test
	/*�����������ڷ��� init��destory*/
	public void fun5() {
		//1.������������
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user3");
		//3.��ӡuser����
		System.out.println(user);
		//�ر��������������ٷ���
		ac.close();
	}
}
