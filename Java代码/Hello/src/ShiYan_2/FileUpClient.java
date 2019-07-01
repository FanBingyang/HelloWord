package ShiYan_2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FileUpClient {

	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("10.85.16.12", 12346);
		OutputStream out = socket.getOutputStream();
		FileInputStream fis = new FileInputStream("./yes.jpg");
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = fis.read(buf))!=-1) {
			out.write(buf,0,len);
		}
		socket.shutdownInput();//标记读取结束，防止客户端和服务端的阻塞方法一直等待，而使程序无法停止
		InputStream in = socket.getInputStream();
		byte[] bufMsg = new byte[1024];
		int num = in.read(bufMsg);
		String Msg = new String(bufMsg,0,num);
		System.out.println(Msg);
		fis.close();
		socket.close();
		
	}
}
