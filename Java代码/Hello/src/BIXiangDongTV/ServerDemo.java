package BIXiangDongTV;
/*
 * 1,客户端：浏览器
 * 服务端：自定义
 * 运行开启服务器
 * 浏览http://localhost:10010/
 * 
 * 
 * 2，客户端：浏览器
 * 服务端：Tomcat服务器
 * 
 * 3，客户端：自定义
 * 服务端：Tomcat服务器
 */
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10010);
		
		Socket s = ss.accept();
		System.out.println(s.getInetAddress().getHostAddress()+"访问了");
		
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024]; 
		
		
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		out.println("<font color='red' size='7'>客户端你好</font>");

		s.close();
		ss.close();
	}

}
