package junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;
import pojo.User;
import pojo.UserExample;

public class JunitTest {

	@Test
	public void testMapper() throws Exception {
		ApplicationContext  aContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserMapper userMapper = aContext.getBean(UserMapper.class);
		UserExample example = new UserExample();
		String username = "明";
		//创建一个内部对象类然后设置性别为1姓名模糊查询为 明
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+ username +"%");
		
		//设置按照id排序
		example.setOrderByClause("id desc");
		
		//查询符合条件用户的个数
		int countByExample = userMapper.countByExample(example);
		System.out.println(countByExample);
		
		//查询表中主键（id）为10的用户
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user+"\n");
		
		//按刚刚设置的条件查询对象
		List<User> users = userMapper.selectByExample(example);
		for (User user2 : users) {
			System.out.println(user2);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
