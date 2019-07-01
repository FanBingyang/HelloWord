package BIXiangDongTV;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * �����ϴ�ͼƬ
 * @author FBY
 */

/*
 * �ͻ���
 * 1������˵�
 * 2����ȡ�ͻ������е�ͼƬ����
 * 3��ͨ��socket����������ݷ��������
 * 4����ȡ����˷�����Ϣ
 * 5���ر�
 */
public class PicClient {

	public static void main(String[] args) throws Exception {
		if(args.length!=1){
			System.out.println("��ѡ��һ��jpg��ʽ��ͼƬ");
			return;
		}
		
		File file = new File(args[0]);
		if(!(file.exists() && file.isFile())){
			System.out.println("���ļ������⣬Ҫô�����ڣ���Ҫô�����ļ�");
			return;
		}
		
		if((!file.getName().endsWith(".jpg")) || (!file.getName().endsWith(".PNG"))){
			System.out.println("ͼƬ��ʽ����������ѡ��");
			return;
		}
		
		if(file.length()>1024*1024*5){//�ļ����ܳ���5M
			System.out.println("�ļ�����");
			return;
		}
		
		
		
		Socket s = new Socket(InetAddress.getLocalHost().getHostAddress(),10005);

		FileInputStream fis = new FileInputStream("D:\\Java\\ҩ��һ.png");
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while ((len=fis.read(buf))!=-1) {
			out.write(buf, 0, len);
		}
		
		//���߷���������Ѿ�д��
		s.shutdownOutput();
		
		InputStream in = s.getInputStream();
		
		byte[] bufIn = new byte[1024];
		
		int num = in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		
		fis.close();
		s.close();
		
	}

}
