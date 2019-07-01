package BIXiangDongTV;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.management.RuntimeErrorException;

/*
 * 服务端
 * 
 * 这个服务端有个局限性，当A客户端连接上以后被服务端获取到，服务端执行具体流程
 * 这时B客户端连接，只有等待
 * 因为服务端还没有处理完A客户 的请求，还有循环来执行下一次accept方法，
 * 所以，暂时获取不到B客户端对象
 * 
 * 那么为了让多个客户端同时并发的访问服务端，
 * 那么服务端最好就是将每个客户端封装到一个单独的线程中，这样就可以同时处理多个客户端的请求
 * 
 * 如何定义线程呢？
 * 只要明确了每一个客户端都要再服务端执行的代码即可，将该代码存入到run方法中即可
 */
public class PicServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10005);

		while (true) {
			Socket s = ss.accept();
			
			new Thread(new PicThread(s)).start();
		}
//		ss.close();
	}

}

class PicThread implements Runnable{

	private Socket s;
	public PicThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		int count = 1;//定义的局部变量，对同一IP发的文件进行计数命名
		String ip = s.getInetAddress().getHostAddress();
		
		try {
			System.out.println(ip+"...连接");
			
			InputStream  in = s.getInputStream();
			
			File file = new File(ip+"("+count+").png");
			
			while(file.exists())//判断文件是否存在，防止文件同名而覆盖
				file = new File(ip+"("+(count++)+").png");
			
			FileOutputStream fos = new FileOutputStream("D:\\Java\\Server药库一.png");
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			while ((len=in.read(buf))!=-1) {
				fos.write(buf,0,len);
			}
			
			OutputStream out = s.getOutputStream();
			
			out.write("上传成功".getBytes());
			
			fos.close();
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(ip+"上传失败");
		}
		
	}
	
}
