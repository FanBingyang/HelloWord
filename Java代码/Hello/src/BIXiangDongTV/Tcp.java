package BIXiangDongTV;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 演示tcp传输
 * 
 * 
 * 1，tcp分客户端和服务端
 * 2，客户端对应的是Socket
 * 		服务端对应的是SeverSocket
 * */


 /*
 *
 * 客户端:
 * 通过查阅Socket对象，发现该对象建立时，就可以去链接指定主机
 * 因为tcp是面向连接的，所以在建立socket过服务时，
 * 就要有服务端存在，并链接成功，形成通路后，在该通道进行数据的传输
 * 
 * 
 * 需求：给i服务端发送文本数据
 * 
 * 步骤：
 * 1，创建socket服务并指定要链接的主机
 * 
 * 
 */

class TcpClient
{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//创建客户端的socket服务，指定目的主机和端口
		Socket s = new Socket("10.85.15.14", 10003);//建立通路
		
		//为了发送数据，应该获取socket流中的输出流
		OutputStream out =s.getOutputStream();
		
		out.write("tcp 哥们来了".getBytes());
		
		s.close();
	}

}

/*
 * 需求：定义断端点接收数据，并打印在控制台上
 * 
 * 服务端：
 * 1,建立服务端的socket，通过SeverSocket()，
 * 	并监听一个端口
 * 2，获取链接过来的客户端对象
 *	通过SeverSocket的accept方法，没有链接就会等，所以这个方法是阻塞式的
 *3，客户端如果发过来数据，那么服务端要使用对应的客户端对象，并获取到该客户端对象的读取流来读取发送过来的的数据
 *	并打印在控制台
 *4，关闭服务端 （可选）
 * 
 */

class TcpSever {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//建立服务端的socket服务，并监听一个端口
		ServerSocket ss= new ServerSocket(10003);
		//通过accept方法获取链接过来的客户端对象
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//获取了客户端的发送过来的数据，那么使用客户端对象的读取流，来读取数据
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		s.close();//关闭客户端
		
		ss.close();
 	}

}

