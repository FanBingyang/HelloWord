package BIXiangDongTV;

import java.io.IOException;
import java.io.InputStream;

/*
 * ��ȡ����¼�롣
 * System.out:��Ӧ���Ǳ�׼������豸������̨��
 * System.in:��Ӧ���Ǳ�׼�������豸�����̡�
 * 
 * ���󣺵�¼��һ�����ݺ󣬾ͽ������ݽ��д�ӡ��
 * ���¼���������over����ô��ֹͣ¼�롣
 */
public class ReadIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		InputStream in = System.in; //��ȡ�Ӽ���¼�������
//		int by = in.read();
//		System.out.println(by);
		
		InputStream in = System.in;//��ȡ�Ӽ���¼�������
		StringBuilder sb =new  StringBuilder();
		
		while(true)
		{
			int ch = in.read();
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				String s = sb.toString();
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());//�����д��ʽ
				sb.delete(0,sb.length());//��ջ�������ɾ����0��sb.length()�����ݣ�
			}
			else
				sb.append((char)ch);
		}
	}

}
