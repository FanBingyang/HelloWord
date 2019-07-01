package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 * 根据姓名处理单个学生的更新，查询学生信息，然后跳转页面
 * @author FBY
 *
 */
@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.接收要查询学生的id
			int id = Integer.parseInt(request.getParameter("id"));
			
			//2.查询学生
			StudentService service = new StudentServiceImpl();
			Student student = service.findById(id);
			
			//3.显示数据
			//存数据
			request.setAttribute("stu", student);
			//跳转
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
			
			/*
			 * jsp小知识点
			 * 1.单选框的状态
			 *  用c：if来判断单选框应该选中那个，分别为其加上判断条件，满足就在input标签里加上checked
			 *  eg：<input type="radio" name="sex" value="男" <c:if test="${stu.sex=='男' }">checked</c:if>>男
			 * 2.多选框的状态
			 *  像爱好这种多选框可以有很多的选项： 篮球 ， 足球 ， 看书 。因为爱好有很多个，  里面存在包含的关系
			 *  所以就可以用c：if来判断从后台得到的数据中是否包含该选项，如果包含，就子啊标签里加上checked，使其为显示状态
			 *	eg:<input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(stu.hobby,'游泳') }">checked</c:if>>游泳
			 */
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
