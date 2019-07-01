package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

/**
 * Servlet implementation class CookieDemo1
 */
//@WebServlet("/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//��ȡ�ͻ��˱�������ķ���ʱ��
		Cookie[] cookies = request.getCookies();//��ÿͻ��˵����е�Cookie
		for (int i = 0; cookies!=null && i < cookies.length;  i++) {
			if("lastAccessTime".equals(cookies[i].getName()))//�жϵ�ǰCookie�е�name�Ƿ�����Ҫ��Cookie
			{
				long l = Long.parseLong(cookies[i].getValue());//�������Ҫ��Cookie,���Cookie�е�Valueȡ��
				out.write("���������ʱ����:"+new Date(l).toLocaleString());//yyyy-MM-dd
				
			}
		}
		//����ʾ�ϴη���ʱ��ĺ������clear����
		out.print("<a href='"+request.getContextPath()+"'>clear</a>");
		
		
		//����cookie,
		Cookie ck = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		//CookieĬ����������˳�ʱɾ��,��ʱmaxAge��Ĭ��ֵ��-1,�������maxAgeΪ0ʱ,�򲻱���Cokie
		//�˴������ǰɸ�Cookie���浽������,������ر�Ҳ�ܱ���,�������Чʱ����,�´η�����Ȼ��Ч
		//����Cookie����Чʱ��,��λ����
		ck.setMaxAge(60*5);//����ʱ��Ϊ5min,
		
		//Cookie��path���ǵ�ǰӦ�ó���ķ���·��
		//��ǰ����·���������Cokie��path��ͷ��·��,������ʹ�,����Ͳ���
		//����Cookie��Path,һ������Ч����ͬ
//		ck.setPath("/HelloServlet");
//		 ck.setPath(request.getContextPath());
//		ck.setPath("/");
		
		//������Ϣд�ص��ͻ���
		response.addCookie(ck);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
