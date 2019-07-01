package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 * ģ����ѯѧ��
 * @author FBY
 *
 */
@WebServlet("/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		try {
			//1.ȡ����ѯ�Ĺؼ����� �������Ա�
			String nam = request.getParameter("nam");
			String sex = request.getParameter("sex");
			
			//2.ִ�в�ѯ
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(nam, sex);
			
			//3.�����ݱ��浽������
			request.setAttribute("list", list);
			
			//4.��תҳ��,��ת���б����
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
