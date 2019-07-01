package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import service.StudentService;
import service.StudentServiceImpl;

/**
 * 这是用于分页显示学生列表的servlet
 * @author FBY
 *
 */
@WebServlet("/studentListPageServlet")
public class StudentListPageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//1.获取需要显示的页数
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			//2.根据指定的页数，去获取该页数的数据
			StudentService service = new StudentServiceImpl();
			PageBean pageBean = service.findStudentByPage(currentPage);
			
			request.setAttribute("pageBean", pageBean);
			//3.跳转页面
			request.getRequestDispatcher("list_page.jsp").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
