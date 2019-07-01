package Test_create;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class Demo {
	@Test
	/*创建方式1：空参构造（重点掌握）*/
	public void fun1() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user");
		
		User user1 = (User)ac.getBean("user");
		User user2 = (User)ac.getBean("user");

		//3.打印user对象
		System.out.println(user);
	}
	
	@Test
	/*创建方式2：静态工厂（了解即可）*/
	public void fun2() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user2");
		//3.打印user对象
		System.out.println(user);
	}
	
	@Test
	/*创建方式3：实例工厂（了解即可）*/
	public void fun3() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user3");
		//3.打印user对象
		System.out.println(user);
	}
	
	@Test
	/* 单例 scope：singleton（默认）。一般选择默认的单例属性
	 * 多例 scope：prototype。只有在整合struts2时，ActionBean必须配置为多例的
	 * */
	public void fun4() {
		//1.创建容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user");
		
		User user1 = (User)ac.getBean("user");
		User user2 = (User)ac.getBean("user");

		//3.打印user对象
		System.out.println(user);
		
		//单例从容器中拿出来的的多个对象是同一个，返回true
		//多例每次从容器中拿出来的的对象都是重新创建的新的对象，返回false
		System.out.println(user1==user2); //true
	}
	
	@Test
	/*测试生命周期方法 init和destory*/
	public void fun5() {
		//1.创建容器对象
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("Test_create/applicationContext.xml");
		//2.向容器“要”对象
		User user = (User)ac.getBean("user3");
		//3.打印user对象
		System.out.println(user);
		//关闭容器，出发销毁方法
		ac.close();
	}
}
