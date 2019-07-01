package service;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDao;
import dao.Impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;
/**
 * 这是学生业务的实现
 * @author FBY
 */
public class StudentServiceImpl implements StudentService{

	@Override
	public List<Student> findAll() throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findAll();
	}

	@Override
	public void insert(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.insert(student);
		
	}

	@Override
	public void delete(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.delete(id);
	}

	@Override
	public Student findById(int id) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.findById(id);
	}

	@Override
	public void update(Student student) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		dao.update(student);
	}

	@Override
	public List<Student> searchStudent(String nam, String sex) throws SQLException {
		StudentDao dao = new StudentDaoImpl();
		return dao.searchStudent(nam, sex);
	}

	@Override
	public PageBean findStudentByPage(int currentPage) throws SQLException {
		//封装分页的该页数据
		PageBean<Student> pageBean = new PageBean<Student>();

		int pageSize = StudentDao.PAGESIZE;
		pageBean.setCurrentPage(currentPage);//设置当前页
		pageBean.setPageSize(pageSize);//设置每页记录数
		
		StudentDao dao = new StudentDaoImpl();
		//当前页的学生数据
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list);
		//总的记录数
		int count = dao.findCount();
		pageBean.setTotalSize(count);
		//总的页数，总页数等于总记录数除以每页显示的个数，整除就直接是该数，不能整除就+1，因为不能整除后直接为int，少了一页显示剩下的内容
		pageBean.setTotalPage(count % pageSize == 0 ? count/pageSize : (count/pageSize)+1 );//这是总的页数
	
		return pageBean;
	}
	
}
