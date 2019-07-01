package test_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class Demo {
	@Test
	/*
	 * ����set����ע��
	 * */
	public void fun1() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user");
		//3.��ӡuser����
		System.out.println(user);
	}
	
	@Test
	/*
	 * ���Թ��췽��ע��
	 * */
	public void fun2() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user2");
		//3.��ӡuser����
		System.out.println(user);
	}
	
	@Test
	/*
	 * ����p���ƿռ䷽��ע��
	 * */
	public void fun3() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user3");
		//3.��ӡuser����
		System.out.println(user);
	}
	
	@Test
	/*
	 * ����spel���ƿռ䷽��ע��
	 * */
	public void fun4() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.��������Ҫ������
		User user = (User)ac.getBean("user4");
		//3.��ӡuser����
		System.out.println(user);
	}
	
	
	@Test
	/*
	 * ��������ע��
	 * */
	public void fun5() {
		//1.������������
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.��������Ҫ������
		CollectionBean cb = (CollectionBean)ac.getBean("cb");
		//3.��ӡuser����
		System.out.println(cb);
	}
	
	
	
}
