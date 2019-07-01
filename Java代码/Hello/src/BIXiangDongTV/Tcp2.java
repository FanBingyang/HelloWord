package BIXiangDongTV;
/*
 * 演示tcp的传输的客户端和服务端的互访
 * 
 * 需求： 客户端给服务端发送数据，服务端收到后，给客户端反馈信息
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端：
 * 1，建立socket的服务，指定要链接的主机和端口
 * 2，获取socket流中的使输出流，将数据写入到该流中，通过网络发送给服务端
 * 3，获取socket流中的输入流，将服务端反馈的数据获取到，并打印
 * 4，关闭客户端资源
 */
class TcpClient2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket s = new Socket("10.85.15.14", 10004);
		
		OutputStream out = s.getOutputStream();
		
		out.write("服务端，你好".getBytes());
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		s.close();
		
	}

}

class TcpSever2
{
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10004);
		
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		OutputStream out = s.getOutputStream();
		
		out.write("收到".getBytes());
		
		
		
 	}
}
