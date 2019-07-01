package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dao.Impl.StudentDaoImpl;
import domain.Student;
import service.StudentService;
import service.StudentServiceImpl;
/**
 * �����ѯ���е�ѧ����Ϣ��Ȼ����ֵ�list.jspҳ����
 * @author FBY
 *
 */
@WebServlet("/studentListServlet")
public class StudentListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.��ѯ���е�ѧ��
			StudentService service  = new StudentServiceImpl();
			List<Student> list = service.findAll();
			
			//2.�����ݴ洢����������
			request.setAttribute("list", list);
			
			//3.��תҳ��
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
