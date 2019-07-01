package BIXiangDongTV;
/**
 * 利用网络编程上传文件，
 * 
 */
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TextServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10004);
		
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...连接");
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter out = new PrintWriter(new FileWriter("D:\\Java\\TextServer.txt"),true);
		
		String line = null;
		
		while ((line=bufIn.readLine())!=null) {
//			if ("over".equals(line)) {//判断自定义节结束标记
//				break;
//			}
			out.println(line);
		}
		
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("上传成功");
		
		
		out.close();
		s.close();
		ss.close();
		
	}
}
