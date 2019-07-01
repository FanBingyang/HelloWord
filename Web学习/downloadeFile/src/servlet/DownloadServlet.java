package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����һ��Ҫ���ص��ļ�
		String filename = "����.csv";
		//�����������,�����ļ����ı���
		if(request.getHeader("user-agent").toLowerCase().contains("msie")){
		filename = URLEncoder.encode(filename, "UTF-8");//������ȫ���ļ�����ΪUTF-8��ʽ
		}else{
			filename = new String(filename.getBytes("UTF-8"),"iso-8859-1");//��������
		} 
		//��֪�����Ҫ�����ļ�
		response.setHeader("content-disposition", "attachment;filename="+filename);
		//�����ļ����Զ�����ļ�����
		response.setContentType(this.getServletContext().getMimeType(filename));
		//��֪������ʹ��ʲô�����ȡ�ļ�
		response.setCharacterEncoding("UTF-8");
		//����һ���ļ������
		PrintWriter out = response.getWriter();
		out.write("���ӻ�,20\n");
		out.write("ϴ�»�,10\n");
		out.write("����,8\n");
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
