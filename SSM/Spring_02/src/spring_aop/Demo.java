package spring_aop;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器时使用那个配置文件
@ContextConfiguration("classpath:spring_aop/applicationContext.xml")
public class Demo {
	@Resource(name="userService")
	private UserService us;
	
	@Test
	public void fun1() {
		
		us.save();
	}
	
	

}
