package service;

import java.sql.SQLException;
import java.util.List;

import domain.PageBean;
import domain.Student;

/**
 * ����ѧ����ҵ����淶
 * @author FBY
 *
 */
public interface StudentService {
	
	/**
	 * ��ѯ��ҳ������
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	PageBean findStudentByPage(int currentPage) throws SQLException;
	
	/**
	 * ��ѯ���е�ѧ��
	 * @return List<Student> 
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * ���ѧ��
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException;
	
	/**
	 *��������ɾ��ѧ��
	 * @param nam
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;
	
	/**
	 * ����ѧ��������ѯѧ����Ϣ
	 * @param nam
	 * @return
	 * @throws SQLException
	 */
	Student findById(int id) throws SQLException;
	
	/**
	 * ����ѧ����Ϣ
	 * @param student ��Ҫ���µ�ѧ������
	 * @throws SQLException
	 */
	void update(Student student) throws SQLException;
	
	/**
	 * ģ����ѯ���������������Ա𣬻�����������
	 * @param nam
	 * @param sex
	 * @return ѧ������
	 * @throws SQLException
	 */
	List<Student> searchStudent(String nam,String sex) throws SQLException;
}
