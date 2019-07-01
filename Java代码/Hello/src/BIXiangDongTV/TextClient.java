package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TextClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(),10004);
		
		BufferedReader bufr = 
				new BufferedReader(new FileReader("D:\\Java\\TextClient.txt"));
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		
		
		String line = null;
		while ((line=bufr.readLine())!=null) {
			out.println(line);
		}
//		out.print("over");//�Զ���������
		socket.shutdownOutput();//�رտͻ��˵���������൱�ڸ����ؼ���һ���������-1
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		String str = bufIn.readLine();
		System.out.println(str);
		
		bufr.close();
		socket.close();

	}

}
