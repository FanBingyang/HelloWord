package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �ͻ�ͨ������¼���û���
 * ����˶�����û�������У��
 * 
 * ������û����ڣ��ٷ������ʾ  XXX���ѵ�¼
 * ���ڿͻ�����ʾ XXX����ӭ����
 * 
 * ������û������ڣ��ٷ������ʾ  XXX�����Ե�¼
 * ���ڿͻ�����ʾ XXX�����û�������
 * 
 * ���͵�¼����
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
			if(info.contains("��ӭ")){
				break;
			}
			
		}
			bufr.close();
			s.close();
	
	}

}
