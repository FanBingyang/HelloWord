package annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.User;

public class Demo {

	@Test
	public void fun1() {
		//1��������������
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2����������Ҫ��user����
		User u = (User)ac.getBean("user");
		//3����ӡuser����
		System.out.println(u);
		
		ac.close();
	}
}
