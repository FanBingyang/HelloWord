package service;

import java.sql.SQLException;
import java.util.List;

import domain.PageBean;
import domain.Student;

/**
 * 这是学生的业务处理规范
 * @author FBY
 *
 */
public interface StudentService {
	
	/**
	 * 查询当页的数据
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException;
	
	/**
	 * 查询所有的学生
	 * @return List<Student> 
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 添加学生
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException;
	
	/**
	 *根据姓名删除学生
	 * @param nam
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;
	
	/**
	 * 根据学生姓名查询学生信息
	 * @param nam
	 * @return
	 * @throws SQLException
	 */
	Student findById(int id) throws SQLException;
	
	/**
	 * 更新学生信息
	 * @param student 需要更新的学生数据
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException;
	
	/**
	 * 模糊查询，根据姓名或者性别，或者两个都有
	 * @param nam
	 * @param sex
	 * @return 学生集合
	 * @throws SQLException
	 */
	List<Student> searchStudent(String nam,String sex) throws SQLException;
}
