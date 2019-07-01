package service;

import java.sql.SQLException;
import java.util.List;

import dao.StudentDao;
import dao.Impl.StudentDaoImpl;
import domain.PageBean;
import domain.Student;
/**
 * ����ѧ��ҵ���ʵ��
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
		//��װ��ҳ�ĸ�ҳ����
		PageBean<Student> pageBean = new PageBean<Student>();

		int pageSize = StudentDao.PAGESIZE;
		pageBean.setCurrentPage(currentPage);//���õ�ǰҳ
		pageBean.setPageSize(pageSize);//����ÿҳ��¼��
		
		StudentDao dao = new StudentDaoImpl();
		//��ǰҳ��ѧ������
		List<Student> list = dao.findStudentByPage(currentPage);
		pageBean.setList(list);
		//�ܵļ�¼��
		int count = dao.findCount();
		pageBean.setTotalSize(count);
		//�ܵ�ҳ������ҳ�������ܼ�¼������ÿҳ��ʾ�ĸ�����������ֱ���Ǹ���������������+1����Ϊ����������ֱ��Ϊint������һҳ��ʾʣ�µ�����
		pageBean.setTotalPage(count % pageSize == 0 ? count/pageSize : (count/pageSize)+1 );//�����ܵ�ҳ��
	
		return pageBean;
	}
	
}
