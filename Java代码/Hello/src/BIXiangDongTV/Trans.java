package BIXiangDongTV;
/*
 * ���󣺽���һ���ı�ת��������
 * �ͻ��˸�����˷���һ���ı�������˻Ὣ�ı�ת���ɴ�д���ٷ��ظ��ͻ���
 * ���ҿͻ��˿��Բ��ϵĽ����ı���ת�������˿ͻ�������overʱ��ת������
 * 
 * 
 * ����:
 * 
 * �ͻ��ˣ�
 * ��Ȼ�ǲ����豸�ϵ����ݣ���ô�Ϳ�����io������������io�Ĳ���������˼��
 * Դ������¼��
 * Ŀ�ģ������豸�����������
 * ���Ҳ��������ı����ݣ�����ѡ���ַ���
 * ���裺
 * 1����������
 * 2����ȡ����¼��
 * 3�������ݷ��������
 * 4����ȥ����˷��صĴ�д
 * 5���������ر�Դ��
 * 
 * �����ı����ݣ�����ʹ���ַ������в�����ͬʱ���Ч�ʣ����뻺��
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class TransClient
{
	public static void main(String[] args) throws Exception {
		Socket s =new Socket("10.85.15.14", 10005);
		
		//�����ȡ�������ݶ���
		BufferedReader bufr =
				new BufferedReader(new InputStreamReader(System.in));
		
		//����Ŀ�ģ�������д�뵽socket����������͸������
//		BufferedWriter bufout =	
//				new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		PrintWriter out = new PrintWriter(s.getOutputStream());
		
		//����һ��socket��ȡ����������ȡ����˷��صĴ�д��Ϣ
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		
		String line = null;
		
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			
			out.println(line);
//			bufout.write(line);
//			bufout.newLine();
//			bufout.flush();
			
			String str = bufIn.readLine();
			System.out.println("Sever:"+str);	
			
		}
		bufr.close();
		s.close();
	}
}

/*
 * ����ˣ�
 * Դ:socket��ȡ��
 * Ŀ�ģ�socket�����
 * �����ı���װ�Ρ�
 */


class TransServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(10005);
		
		Socket s = ss.accept();
		String ip = s.getInetAddress().getHostAddress();
		System.out.println(ip+"...connected");
		
		//��ȡsocket��ȡ���е�����
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		//Ŀ�ģ�socket�����������д����д�뵹socket������������͸��ͻ���
//		BufferedWriter bufOut = 
//				new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		String line = null;
		while((line=bufIn.readLine())!=null)
		{
			out.println(line.toUpperCase());
//			bufOut.write(line.toUpperCase());
//			bufOut.newLine();//��ӻ���'\r\n'
//			bufOut.flush();
		}
		
		s.close();
		ss.close();
		
	}

}

/*
 * �����ӳ��ֵ����⣺
 * ����:�ͻ��˺ͷ���˶���Ī���ĵȴ�
 * Ϊʲô��
 * ��Ϊ�ͻ��˺ͷ���˶�������ʽ�ķ�������Щ����û�ж���������ǣ���ô��һֱ��
 * ���������˶��ڵȴ���
 * 
 */
