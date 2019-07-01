package test_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class Demo {
	@Test
	/*
	 * 测试set方法注入
	 * */
	public void fun1() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user");
		//3.打印user对象
		System.out.println(user);
	}
	
	@Test
	/*
	 * 测试构造方法注入
	 * */
	public void fun2() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user2");
		//3.打印user对象
		System.out.println(user);
	}
	
	@Test
	/*
	 * 测试p名称空间方法注入
	 * */
	public void fun3() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user3");
		//3.打印user对象
		System.out.println(user);
	}
	
	@Test
	/*
	 * 测试spel名称空间方法注入
	 * */
	public void fun4() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user4");
		//3.打印user对象
		System.out.println(user);
	}
	
	
	@Test
	/*
	 * 复杂类型注入
	 * */
	public void fun5() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("test_injection/applicationContext.xml");
		//2.向容器“要”对象
		CollectionBean cb = (CollectionBean)ac.getBean("cb");
		//3.打印user对象
		System.out.println(cb);
	}
	
	
	
}
