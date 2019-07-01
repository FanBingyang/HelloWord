package dao;

import java.sql.SQLException;
import java.util.List;

import domain.Student;

/**
 * �������ѧ��������ݷ���
 * @author FBY
 *
 */
public interface StudentDao {

	int PAGESIZE = 5;//��ʾһҳҪ��ʾ������
	
	/**
	 * ��ѯ��ҳ��ѧ������
	 * @param currentPage
	 * @return
	 * @throws SQLException
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
	
	/**
	 * ��ѯ���е�ѧ��
	 * @return List<Student> 
	 * @throws SQLException
	 */
	List<Student> findAll() throws SQLException;
	
	/**
	 * ���ѧ��
	 * @param student
	 * @throws SQLException
	 */
	void insert(Student student) throws SQLException;
	
	/**
	 *����idɾ��ѧ��
	 * @param id
	 * @throws SQLException
	 */
	void delete(int id) throws SQLException;
	
	/**
	 * ����ѧ��id��ѯѧ����Ϣ
	 * @param id
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
	
	/**
	 * ��ѯ�ܵ�ѧ����¼��
	 * @return
	 * @throws SQLException
	 */
	int findCount() throws SQLException;
}
