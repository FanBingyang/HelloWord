package BookHistory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showBookDetail
 */
//@WebServlet("/showBookDetail")
public class showBookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showBookDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//��ʾͼ�����ϸ��Ϣ
		
		
		
		//���id
		String id = request.getParameter("id");
		
		Book book = DBUtil.findBookById(id);
		
		//out.write(book.toString());
		out.print(book);
		//�ѵ�ǰ���������д�ص��ͻ���
		String historyBookId=organizeId(id,request);
		Cookie ck = new Cookie("historyBookId",historyBookId);
		ck.setPath("/");
		ck.setMaxAge(Integer.MAX_VALUE);
		
		response.addCookie(ck);//д�ص��ͻ���
		
		
	}
	/**
	 * �ͻ���					showAllBooks	showBookDetail
	 * û��Cookie					1			historyBookId=1
	 * ��cookie,����
	 * û��historyBookId    	 	1			historyBookId=1
	 * historyBookId=1			2			historyBookId=2-1
	 * historyBookId=1-2		2			historyBookId=2-1
	 * historyBookId=1-2-3  	2			historyBookId=2-1-3
	 * historyBookId=1-2-3  	4			historyBookId=4-1-2
	 
	 * @param id
	 * @param request
	 * @return
	 */
	
	
	
	private String organizeId(String id, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//�õ��ͻ��˵�Cookie
		Cookie[] cookies = request.getCookies();
		if(cookies==null)
			return id;
		
		//������û��name����historyBookId��cookie
		Cookie historyBook = null;
		for (int i = 0; i < cookies.length; i++) {
			if("historyBookId".equals(cookies[i].getName())) {
				historyBook = cookies[i];
			}
		}
		
		//���û��historyBookId��cookie,�򷵻�id
		if(historyBook==null)
			return id;
		
		String value = historyBook.getValue();//2-1-3
		String[] values = value.split("-");
		LinkedList<String> list = new LinkedList<String>(Arrays.asList(values));
		
		if(list.size()<3) {// 1 2
			if(list.contains(id))
			{
				list.remove(id);//���������ǰid��ֵ,��ɾ�����id
			}
		}else {
			if(list.contains(id))
			{
				list.remove(id);//���������ǰid��ֵ,��ɾ�����id
			}
			else {//˵����3�����id
				list.removeLast();//�����һ��ɾ��
			}
		}
		list.addFirst(id);//���µ����id��ӵ���ǰ��
		
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<list.size();i++) {
			if(i>0) {
				sb.append("-");
			}
			sb.append(list.get(i));
		}
		
		System.out.println(sb);//1-2-3
		return sb.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
