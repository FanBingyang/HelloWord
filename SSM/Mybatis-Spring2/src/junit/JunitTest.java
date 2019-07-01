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
		String username = "��";
		//����һ���ڲ�������Ȼ�������Ա�Ϊ1����ģ����ѯΪ ��
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+ username +"%");
		
		//���ð���id����
		example.setOrderByClause("id desc");
		
		//��ѯ���������û��ĸ���
		int countByExample = userMapper.countByExample(example);
		System.out.println(countByExample);
		
		//��ѯ����������id��Ϊ10���û�
		User user = userMapper.selectByPrimaryKey(10);
		System.out.println(user+"\n");
		
		//���ո����õ�������ѯ����
		List<User> users = userMapper.selectByExample(example);
		for (User user2 : users) {
			System.out.println(user2);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
