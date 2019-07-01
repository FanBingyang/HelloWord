package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Student;

/**
 * 这是针对学生表的数据访问
 * @author FBY
 *
 */
public interface StudentDao {

	int PAGESIZE = 5;//表示一页要显示的数据
	
	/**
	 * 查询当页的学生数据
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
	
	/**
	 * 查询所有的学生
	 * @return List<Student> 
	 * @throws SQLException
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * 添加学生
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException;
	
	/**
	 *根据id删除学生
	 * @param id
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;
	
	/**
	 * 根据学生id查询学生信息
	 * @param id
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
	
	/**
	 * 查询总的学生记录数
	 * @return
	 * @throws SQLException
	 */
	int findCount() throws SQLException;
}
