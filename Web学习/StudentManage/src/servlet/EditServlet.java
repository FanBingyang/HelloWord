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
 * ��������������ѧ���ĸ��£���ѯѧ����Ϣ��Ȼ����תҳ��
 * @author FBY
 *
 */
@WebServlet("/editServlet")
public class EditServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.����Ҫ��ѯѧ����id
			int id = Integer.parseInt(request.getParameter("id"));
			
			//2.��ѯѧ��
			StudentService service = new StudentServiceImpl();
			Student student = service.findById(id);
			
			//3.��ʾ����
			//������
			request.setAttribute("stu", student);
			//��ת
			request.getRequestDispatcher("edit.jsp").forward(request, response);
			
			
			/*
			 * jspС֪ʶ��
			 * 1.��ѡ���״̬
			 *  ��c��if���жϵ�ѡ��Ӧ��ѡ���Ǹ����ֱ�Ϊ������ж��������������input��ǩ�����checked
			 *  eg��<input type="radio" name="sex" value="��" <c:if test="${stu.sex=='��' }">checked</c:if>>��
			 * 2.��ѡ���״̬
			 *  �񰮺����ֶ�ѡ������кܶ��ѡ� ���� �� ���� �� ���� ����Ϊ�����кܶ����  ������ڰ����Ĺ�ϵ
			 *  ���ԾͿ�����c��if���жϴӺ�̨�õ����������Ƿ������ѡ�������������Ӱ���ǩ�����checked��ʹ��Ϊ��ʾ״̬
			 *	eg:<input type="checkbox" name="hobby" value="��Ӿ" <c:if test="${fn:contains(stu.hobby,'��Ӿ') }">checked</c:if>>��Ӿ
			 */
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
