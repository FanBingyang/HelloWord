package junit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import mapper.OrderMapper;
import mapper.UserMapper;
import pojo.Orders;
import pojo.User;

public class MybatisMapperTest2 {

	@Test
	public void testOrderList() throws Exception {
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSeession��������һ��ʵ����(���ӿ�)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<Orders> selectOrdersList = orderMapper.selectOrders();
		
		for (Orders orders : selectOrdersList) {
			System.out.println(orders);
		}	
	}
	
	@Test
	public void testUserList() throws Exception {
		//���غ��������ļ�
		String resource = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory����
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//SqlSeession��������һ��ʵ����(���ӿ�)
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		List<User> users = orderMapper.selectUserList();
		
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
}
