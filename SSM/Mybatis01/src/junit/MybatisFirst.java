package junit;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import pojo.User;

public class MybatisFirst {

	@Test
	public void testMybatis() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��Sql��� 
		User user = sqlSession.selectOne("findUserById", 10);
		
		System.out.println(user);
	}
	//�����û�����ģ����ѯ�û��б�
	@Test
	public void testfindUserByUsername() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��Sql��� 
		List<User> users = sqlSession.selectList("findUserByUsername", "��");
		for (User user2 : users) {
			System.out.println(user2);
			
		}
	}
	//����û�
	@Test
	public void testInsertUser() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��Sql��� 
		User user = new User();
		user.setUsername("����");
		user.setBirthday(new Date());
		user.setAddress("sadfsafsafs");
		user.setSex("��");
		int i = sqlSession.insert("insertUser", user);
		
		sqlSession.commit();
		
		System.out.println(user.getId());
		
	}
	//�����û�
	@Test
	public void testUpdateUserById() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//ִ��Sql��� 
		User user = new User();
		user.setId(28);
		user.setUsername("����292929");
		user.setBirthday(new Date());
		user.setAddress("222222sadfsafsafs");
		user.setSex("Ů");
		int i = sqlSession.update("updateUserById", user);
		sqlSession.commit();
	}
	//ɾ��
	@Test
	public void testDelete() throws Exception {
		//���غ��������ļ�
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//����SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.delete("deleteUserById", 27);
		sqlSession.commit();
	}
}
