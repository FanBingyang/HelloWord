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
 * 模糊查询学生
 * @author FBY
 *
 */
@WebServlet("/searchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		try {
			//1.取到查询的关键数据 姓名、性别
			String nam = request.getParameter("nam");
			String sex = request.getParameter("sex");
			
			//2.执行查询
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.searchStudent(nam, sex);
			
			//3.将数据保存到作用域
			request.setAttribute("list", list);
			
			//4.跳转页面,跳转到列表界面
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
