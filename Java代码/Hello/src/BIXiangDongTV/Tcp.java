package BIXiangDongTV;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ��ʾtcp����
 * 
 * 
 * 1��tcp�ֿͻ��˺ͷ����
 * 2���ͻ��˶�Ӧ����Socket
 * 		����˶�Ӧ����SeverSocket
 * */


 /*
 *
 * �ͻ���:
 * ͨ������Socket���󣬷��ָö�����ʱ���Ϳ���ȥ����ָ������
 * ��Ϊtcp���������ӵģ������ڽ���socket������ʱ��
 * ��Ҫ�з���˴��ڣ������ӳɹ����γ�ͨ·���ڸ�ͨ���������ݵĴ���
 * 
 * 
 * ���󣺸�i����˷����ı�����
 * 
 * ���裺
 * 1������socket����ָ��Ҫ���ӵ�����
 * 
 * 
 */

class TcpClient
{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//�����ͻ��˵�socket����ָ��Ŀ�������Ͷ˿�
		Socket s = new Socket("10.85.15.14", 10003);//����ͨ·
		
		//Ϊ�˷������ݣ�Ӧ�û�ȡsocket���е������
		OutputStream out =s.getOutputStream();
		
		out.write("tcp ��������".getBytes());
		
		s.close();
	}

}

/*
 * ���󣺶���϶˵�������ݣ�����ӡ�ڿ���̨��
 * 
 * ����ˣ�
 * 1,��������˵�socket��ͨ��SeverSocket()��
 * 	������һ���˿�
 * 2����ȡ���ӹ����Ŀͻ��˶���
 *	ͨ��SeverSocket��accept������û�����Ӿͻ�ȣ������������������ʽ��
 *3���ͻ���������������ݣ���ô�����Ҫʹ�ö�Ӧ�Ŀͻ��˶��󣬲���ȡ���ÿͻ��˶���Ķ�ȡ������ȡ���͹����ĵ�����
 *	����ӡ�ڿ���̨
 *4���رշ���� ����ѡ��
 * 
 */

class TcpSever {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//��������˵�socket���񣬲�����һ���˿�
		ServerSocket ss= new ServerSocket(10003);
		//ͨ��accept������ȡ���ӹ����Ŀͻ��˶���
		Socket s = ss.accept();
		
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//��ȡ�˿ͻ��˵ķ��͹��������ݣ���ôʹ�ÿͻ��˶���Ķ�ȡ��������ȡ����
		InputStream in = s.getInputStream();
		
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		
		System.out.println(new String(buf,0,len));
		
		s.close();//�رտͻ���
		
		ss.close();
 	}

}

