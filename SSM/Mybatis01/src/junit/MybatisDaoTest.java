package junit;

import java.io.InputStream;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import pojo.User;

public class MybatisDaoTest {
	
	public SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void befor() throws Exception
	{
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
	
	@Test
	public void testDao() throws Exception
	{
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		//��ѯ�û�
		User user = userDao.selectUserById(10);
		System.out.println(user);
	}
}
