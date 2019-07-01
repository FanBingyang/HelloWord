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
 * 这是StudentDao的实现，针对前面定义的规范，做出具体的实现
 * @author FBY
 *
 */
public class StudentDaoImpl  implements StudentDao{

	
	/*
	 * 查询所有学生
	 * @see dao.StudentDao#findAll()
	 */
	@Override
	public List<Student> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		return runner.query("select * from student", new BeanListHandler<Student>(Student.class)); 
	}

	/**
	 * 添加学生
	 */
	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		runner.update("insert into student values(null,?,?,?,?,?)",student.getNam(),student.getSex(),student.getZhuanye(),student.getBanji(),student.getXuehao()); 
		
	}

	/**
	 * 删除学生
	 */
	@Override
	public void delete(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		runner.update("delete from student where id=?",id);
		
	}

	/**
	 * 更新查询
	 */
	@Override
	public Student findById(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		return runner.query("select * from student where id = ?", new BeanHandler<Student>(Student.class),id);
		
	}

	/**
	 * 更新学生信息
	 */
	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		runner.update("update student set nam=?,sex=?,zhuanye=?,banji=?,xuehao=? where id=?",student.getNam(),student.getSex(),student.getZhuanye(),student.getBanji(),student.getXuehao(),student.getId()); 
		
	}

	/**
	 * 模糊查询学生
	 */
	@Override
	public List<Student> searchStudent(String nam, String sex) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		
		/*
		 * 这里要分析以下
		 * 如果只有姓名 select * from student where nam like ?
		 * 如果只有性别  select * from student where sex = ?
		 * 
		 * 如果两个都有  select * from student where nam like ? and sex = ?
		 * 
		 * 如果两个都没有就查询所有 select * from student
		 * 
		 * 根据以上分析，应该对sql语句进行拼接
		 */
		
		//sql语句后面跟着where 1 = 1，保证有没有选条件都会进行查询
		String sql = "select * from student where 1=1";
		//该list用来存储sql语句中需要的参数，nam，sex，
		List<String> list = new ArrayList<String>();
		//判断有没有查询条件有没有nam
		if(!TextUtils.isEmpty(nam)) {
			sql = sql + " and nam like ?";
			list.add("%"+nam+"%");
		}
		//判断有没有查询条件有没有sex
		if(!TextUtils.isEmpty(sex)) {
			sql = sql + " and sex = ?";
			list.add(sex);
		}
		
//		System.out.println(sql);
		
		//因为不知道sql语句中参数的个数，所以在query语句后面传入数组对象list,将list转换成数组，当作参数传入query语句
		return runner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
		
	}
	
	
	/**
	 * 分页查寻
	 */
	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(C3P0Util.getDataSource());
		//sql语句中第一个问号代表一页返回多少条记录，第二个问好代表跳过前面多少记录
		//eg：查询第一页5条数据    5 0---（1-1）*5
		//eg：查询第二页5条数据    5 5---（2-1）*5
		return runner.query("select * from student limit ? offset ?",new BeanListHandler<Student>(Student.class),PAGESIZE,(currentPage-1)*PAGESIZE);

	}

	/**
	 * 查询总的记录数
	 */
	@Override
	public int findCount() throws SQLException {
		QueryRunner runner =new QueryRunner(C3P0Util.getDataSource());
		//用于返回平均值，总的个数 ScalarHandler(),返回的是Object类型
		Long result = (Long)runner.query("select count(*) from student",new ScalarHandler());
		return result.intValue();
	}

}
