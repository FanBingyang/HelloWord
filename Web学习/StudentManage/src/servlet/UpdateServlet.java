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

/***
 * 修改学生信息之后保存到数据库
 * @author FBY
 *
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		

		//1.获取客户端提交的数据
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String zhuanye = request.getParameter("zhuanye");
		String banji = request.getParameter("banji");
		String xuehao = request.getParameter("xuehao");
		
		//两个小知识点
		/*
			String---->Date
			将取出的字符串转换成Date日期类型
			Date date = new SimpleDateFoemat("yyyy-MM-dd").parse(Stirng str);
		*/
		/*
			获取多选框的所有选项，如果用getParameter的话，就只会得到第一个复选框的值
			用以下方法得到的是一个字符串数组
			String[] hobby = request.getParameterValues("hobby");
			然后用Arrays.toString(hobby);转换成字符串，得到的结果是[游泳，读书，看报]
			在存进数据库时应该将前后[]去掉
			hobby = Arrays.toString(hobby)
			hobby = hobby.subString(1,hobby.lenth()-1);对字符串进行截取
		*/
		
		try {
			//2.添加到数据库
			Student student = new Student(id,name, sex, zhuanye, banji, xuehao);
			
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			//3.跳转页面
			//这里是直接跳到页面上，那么这个页面会重新翻译一次，之前的那个request请求存放的数据是没有了
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			
			//servlet除了能跳转到jsp之外，还能跳转到servlet
			request.getRequestDispatcher("studentListServlet").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
