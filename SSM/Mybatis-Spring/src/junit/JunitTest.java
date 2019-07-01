package junit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;

public class JunitTest {

	@Test
	public void testMapper() throws Exception {
		ApplicationContext  aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = aContext.getBean(UserMapper.class);
//		UserMapper mapper2 = (UserMapper)aContext.getBean("userMapper");//第二种获取方法
		User user = mapper.findUserById(10);
		System.out.println(user);
	}
}
