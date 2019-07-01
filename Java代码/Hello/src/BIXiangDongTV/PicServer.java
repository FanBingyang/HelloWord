package BIXiangDongTV;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.management.RuntimeErrorException;

/*
 * �����
 * 
 * ���������и������ԣ���A�ͻ����������Ժ󱻷���˻�ȡ���������ִ�о�������
 * ��ʱB�ͻ������ӣ�ֻ�еȴ�
 * ��Ϊ����˻�û�д�����A�ͻ� �����󣬻���ѭ����ִ����һ��accept������
 * ���ԣ���ʱ��ȡ����B�ͻ��˶���
 * 
 * ��ôΪ���ö���ͻ���ͬʱ�����ķ��ʷ���ˣ�
 * ��ô�������þ��ǽ�ÿ���ͻ��˷�װ��һ���������߳��У������Ϳ���ͬʱ�������ͻ��˵�����
 * 
 * ��ζ����߳��أ�
 * ֻҪ��ȷ��ÿһ���ͻ��˶�Ҫ�ٷ����ִ�еĴ��뼴�ɣ����ô�����뵽run�����м���
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
		int count = 1;//����ľֲ���������ͬһIP�����ļ����м�������
		String ip = s.getInetAddress().getHostAddress();
		
		try {
			System.out.println(ip+"...����");
			
			InputStream  in = s.getInputStream();
			
			File file = new File(ip+"("+count+").png");
			
			while(file.exists())//�ж��ļ��Ƿ���ڣ���ֹ�ļ�ͬ��������
				file = new File(ip+"("+(count++)+").png");
			
			FileOutputStream fos = new FileOutputStream("D:\\Java\\Serverҩ��һ.png");
			
			byte[] buf = new byte[1024];
			
			int len = 0;
			while ((len=in.read(buf))!=-1) {
				fos.write(buf,0,len);
			}
			
			OutputStream out = s.getOutputStream();
			
			out.write("�ϴ��ɹ�".getBytes());
			
			fos.close();
			s.close();
		} catch (Exception e) {
			throw new RuntimeException(ip+"�ϴ�ʧ��");
		}
		
	}
	
}
