package BIXiangDongTV;
/*
 * 1,�ͻ��ˣ������
 * ����ˣ��Զ���
 * ���п���������
 * ���http://localhost:10010/
 * 
 * 
 * 2���ͻ��ˣ������
 * ����ˣ�Tomcat������
 * 
 * 3���ͻ��ˣ��Զ���
 * ����ˣ�Tomcat������
 */
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10010);
		
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"������");
		
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024]; 
		
		
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("<font color='red' size='7'>�ͻ������</font>");

		s.close();
		ss.close();
	}

}
