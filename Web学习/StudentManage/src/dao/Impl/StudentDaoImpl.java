package dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.StudentDao;
import domain.Student;
import util.C3P0Util;
import util.TextUtils;


/**
 * ����StudentDao��ʵ�֣����ǰ�涨��Ĺ淶�����������ʵ��
 * @author FBY
 *
 */
public class StudentDaoImpl  implements StudentDao{

	
	/*
	 * ��ѯ����ѧ��
	 * @see dao.StudentDao#findAll()
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		return runner.query("select * from student", new BeanListHandler<Student>(Student.class)); 
	}

	/**
	 * ���ѧ��
	 */
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		runner.update("insert into student values(null,?,?,?,?,?)",student.getNam(),student.getSex(),student.getZhuanye(),student.getBanji(),student.getXuehao()); 
		
	}

	/**
	 * ɾ��ѧ��
	 */
	@Override
	public void delete(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		runner.update("delete from student where id=?",id);
		
	}

	/**
	 * ���²�ѯ
	 */
	@Override
	public Student findById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		return runner.query("select * from student where id = ?", new BeanHandler<Student>(Student.class),id);
		
	}

	/**
	 * ����ѧ����Ϣ
	 */
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		runner.update("update student set nam=?,sex=?,zhuanye=?,banji=?,xuehao=? where id=?",student.getNam(),student.getSex(),student.getZhuanye(),student.getBanji(),student.getXuehao(),student.getId()); 
		
	}

	/**
	 * ģ����ѯѧ��
	 */
	@Override
	public List<Student> searchStudent(String nam, String sex) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		
		/*
		 * ����Ҫ��������
		 * ���ֻ������ select * from student where nam like ?
		 * ���ֻ���Ա�  select * from student where sex = ?
		 * 
		 * �����������  select * from student where nam like ? and sex = ?
		 * 
		 * ���������û�оͲ�ѯ���� select * from student
		 * 
		 * �������Ϸ�����Ӧ�ö�sql������ƴ��
		 */
		
		//sql���������where 1 = 1����֤��û��ѡ����������в�ѯ
		String sql = "select * from student where 1=1";
		//��list�����洢sql�������Ҫ�Ĳ�����nam��sex��
		List<String> list = new ArrayList<String>();
		//�ж���û�в�ѯ������û��nam
		if(!TextUtils.isEmpty(nam)) {
			sql = sql + " and nam like ?";
			list.add("%"+nam+"%");
		}
		//�ж���û�в�ѯ������û��sex
		if(!TextUtils.isEmpty(sex)) {
			sql = sql + " and sex = ?";
			list.add(sex);
		}
		
//		System.out.println(sql);
		
		//��Ϊ��֪��sql����в����ĸ�����������query�����洫���������list,��listת�������飬������������query���
		return runner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
		
	}
	
	
	/**
	 * ��ҳ��Ѱ
	 */
	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		//sql����е�һ���ʺŴ���һҳ���ض�������¼���ڶ����ʺô�������ǰ����ټ�¼
		//eg����ѯ��һҳ5������    5 0---��1-1��*5
		//eg����ѯ�ڶ�ҳ5������    5 5---��2-1��*5
		return runner.query("select * from student limit ? offset ?",new BeanListHandler<Student>(Student.class),PAGESIZE,(currentPage-1)*PAGESIZE);

	}

	/**
	 * ��ѯ�ܵļ�¼��
	 */
	@Override
	public int findCount() throws SQLException {
		QueryRunner runner =new QueryRunner(C3P0Util.getDataSource());
		//���ڷ���ƽ��ֵ���ܵĸ��� ScalarHandler(),���ص���Object����
		Long result = (Long)runner.query("select count(*) from student",new ScalarHandler());
		return result.intValue();
	}

}
