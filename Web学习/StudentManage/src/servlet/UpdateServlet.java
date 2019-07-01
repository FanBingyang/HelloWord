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
 * �޸�ѧ����Ϣ֮�󱣴浽���ݿ�
 * @author FBY
 *
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		

		//1.��ȡ�ͻ����ύ������
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String zhuanye = request.getParameter("zhuanye");
		String banji = request.getParameter("banji");
		String xuehao = request.getParameter("xuehao");
		
		//����С֪ʶ��
		/*
			String---->Date
			��ȡ�����ַ���ת����Date��������
			Date date = new SimpleDateFoemat("yyyy-MM-dd").parse(Stirng str);
		*/
		/*
			��ȡ��ѡ�������ѡ������getParameter�Ļ�����ֻ��õ���һ����ѡ���ֵ
			�����·����õ�����һ���ַ�������
			String[] hobby = request.getParameterValues("hobby");
			Ȼ����Arrays.toString(hobby);ת�����ַ������õ��Ľ����[��Ӿ�����飬����]
			�ڴ�����ݿ�ʱӦ�ý�ǰ��[]ȥ��
			hobby = Arrays.toString(hobby)
			hobby = hobby.subString(1,hobby.lenth()-1);���ַ������н�ȡ
		*/
		
		try {
			//2.��ӵ����ݿ�
			Student student = new Student(id,name, sex, zhuanye, banji, xuehao);
			
			StudentService service = new StudentServiceImpl();
			service.update(student);
			
			//3.��תҳ��
			//������ֱ������ҳ���ϣ���ô���ҳ������·���һ�Σ�֮ǰ���Ǹ�request�����ŵ�������û����
			//request.getRequestDispatcher("list.jsp").forward(request, response);
			
			//servlet��������ת��jsp֮�⣬������ת��servlet
			request.getRequestDispatcher("studentListServlet").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
