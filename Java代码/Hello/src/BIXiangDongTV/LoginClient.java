package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户通过键盘录入用户名
 * 服务端对这个用户名进行校验
 * 
 * 如果该用户存在，再服务端显示  XXX，已登录
 * 并在客户端显示 XXX，欢迎光临
 * 
 * 如果该用户不存在，再服务端显示  XXX，尝试登录
 * 并在客户端显示 XXX，该用户不存在
 * 
 * 最多就登录三次
 * @author FBY
 *
 */
public class LoginClient {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket(InetAddress.getLocalHost().getHostAddress(),10006);

		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		
		BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		for (int i = 0; i < 3; i++) {
			String line = bufr.readLine();
			if (line==null) {
				break;
			}
			out.println(line);
			
			String info = bufIn.readLine();
			System.out.println("info"+info);
			if(info.contains("欢迎")){
				break;
			}
			
		}
			bufr.close();
			s.close();
	
	}

}
