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
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class WenBenZhuanHuan {
	public static void main(String[] args) {
		
	}
}

class TransClient1
{
	public static void main(String[] args) throws Exception {
		Socket s =new Socket("10.85.16.12", 10006);
		
		//�����ȡ�������ݶ���
		BufferedReader bufr =
				new BufferedReader(new InputStreamReader(System.in));
		
		//����Ŀ�ģ�������д�뵽socket����������͸������
		BufferedWriter bufout =	
				new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//����һ��socket��ȡ����������ȡ����˷��صĴ�д��Ϣ
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		
		String line = null;
		
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			
			bufout.write(line);
			
			String str = bufIn.readLine();
			System.out.println("Sever:"+str);	
		}
		bufr.close();
		s.close();
	}
}


