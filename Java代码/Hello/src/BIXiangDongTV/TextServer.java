package BIXiangDongTV;
/**
 * �����������ϴ��ļ���
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
		System.out.println(ip+"...����");
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		PrintWriter out = new PrintWriter(new FileWriter("D:\\Java\\TextServer.txt"),true);
		
		String line = null;
		
		while ((line=bufIn.readLine())!=null) {
//			if ("over".equals(line)) {//�ж��Զ���ڽ������
//				break;
//			}
			out.println(line);
		}
		
		
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		pw.println("�ϴ��ɹ�");
		
		
		out.close();
		s.close();
		ss.close();
		
	}
}
