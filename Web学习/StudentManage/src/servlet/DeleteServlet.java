package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StudentService;
import service.StudentServiceImpl;

/**
 * 删除学生信息
 * @author FBY
 *
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.接收删除id
			int id = Integer.parseInt(request.getParameter("id"));
			
			//2.执行删除
			StudentService service = new  StudentServiceImpl();
			service.delete(id);
			
			//3.跳转页面
			request.getRequestDispatcher("studentListServlet").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
