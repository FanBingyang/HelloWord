package BIXiangDongTV;
/*
 * ��ʾtcp�Ĵ���Ŀͻ��˺ͷ���˵Ļ���
 * 
 * ���� �ͻ��˸�����˷������ݣ�������յ��󣬸��ͻ��˷�����Ϣ
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ��ˣ�
 * 1������socket�ķ���ָ��Ҫ���ӵ������Ͷ˿�
 * 2����ȡsocket���е�ʹ�������������д�뵽�����У�ͨ�����緢�͸������
 * 3����ȡsocket���е���������������˷��������ݻ�ȡ��������ӡ
 * 4���رտͻ�����Դ
 */
class TcpClient2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Socket s = new Socket("10.85.15.14", 10004);
		
		OutputStream out = s.getOutputStream();
		
		out.write("����ˣ����".getBytes());
		
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
		
		out.write("�յ�".getBytes());
		
		
		
 	}
}
