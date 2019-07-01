package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pojo.User;


/**
 * Dao
 * @author lx
 *
 */
public class UserDaoImpl implements UserDao {

	//ע�룬��������
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	//ͨ���û�ID��ѯһ���û�
	public User selectUserById(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectOne("findUserById", id);
	}
	//ͨ���û�����ģ����ѯ
	public List<User> selectUserByUsername(Integer id){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession.selectList("findUserById", id);
	}
	
}
