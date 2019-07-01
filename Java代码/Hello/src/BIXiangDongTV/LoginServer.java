package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(10006);
		
		while (true) {
			Socket s = ss.accept();
			
			new Thread(new UserThread(s)).start();
		}
		
	}

}

class UserThread implements Runnable{
	private Socket s;
	public UserThread(Socket s) {
		this.s = s;
	}

	@Override
	public void run() {
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...����");
		try {
			for (int i = 0; i < 3; i++) {
				BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				String name = bufIn.readLine();
				if(name==null)
					break;
				BufferedReader bufr = new BufferedReader(new FileReader("D:\\Java\\user.txt"));
				
				PrintWriter out = new PrintWriter(s.getOutputStream());
				
				String line = null;
				boolean flag = false;
				while ((line=bufr.readLine())!=null) {
					if(line.equals(name)){
						flag = true;
						break;
					}
				}
				
				if(flag){
					System.out.println(name+",�ѵ�¼");
					out.println(name+",��ӭ����");
					break;
				}else {
					System.out.println(name+",���Ե�¼");
					out.print("�û�������");
				}
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
