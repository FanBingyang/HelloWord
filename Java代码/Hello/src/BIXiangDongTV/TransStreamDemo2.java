package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
/*
 * 1��������Ѽ���¼������ݵĴ�д��ӡ�ٿ���̨��
 * Դ������¼��
 * Ŀ�ģ�����̨��
 * 
 * 2��������Ѽ���¼������ݴ洢��һ���ļ���
 * Դ������
 * Ŀ�ģ��ļ�
 * 
 * 3��������Ҫ��һ���ļ������ݴ�ӡ�ٿ���̨�ϡ�
 * Դ:�ļ���
 * Ŀ�ģ�����̨
 * 
 ********************************************************************
 * �������Ļ������ɣ�
 * ��ʹ��ľ����������кܶ࣬��֪��������һ����
 * 
 * ͨ��������ȷ����ɡ�
 * 1����ȷԴ��Ŀ�ġ�
 * 		Դ:��������InputStream  Reader
 * 		Ŀ��:�������OutputStream  Writer��
 * 2����ȷ�����������Ƿ��Ǵ��ı���
 * 		�ǣ��ַ�����
 * 		���ǣ��ֽ�����
 * 3������ϵ��ȷ������ȷҪʹ���ĸ�����Ķ���
 * 		ͨ���豸����������
 * 		Դ�豸���ڴ棬Ӳ�̣�����
 * 		Ŀ���豸���ڴ棬Ӳ�̣�����̨
 *  
 ********************************************************************
 *  ��չ��
 *  ��Ҫ��¼������ݰ���ָ���ı����(utf-8���������ݴ浽�ļ��ϡ�
 *  �洢ʱ��Ҫ����ָ���ı������ָ���ı����ֻ��ת��������ָ����Ĭ�ϵı����ΪGBK
 *  ����Ҫ�õĶ�����OutputStreamWriter��
 *  ����ת��������Ҫ����һ���ֽ������������һ����Բ����ļ����ֽ��������FileOutputStream
 *  
 *  ʾ�����룺OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d.txt","UTF-8");   "d.txt"��Ҫ�������ļ���"UTF-8"ָ�������
 *  																				 
 *  ��Ҫ��Ч��ʾ�����룺
 *  BufferedWriter bufw = new BufferedWriter(osw);
 *  
 ****���ԣ�ת����ʲôʱ��ʹ���أ�
 *  	�ַ����ֽ�֮���������ͨ�����漰���ַ�����ת��ʱ����Ҫ�õ�ת������
 *  
 * 
 * 
 */
public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//�޸�Ĭ�ϵļ���Դ�����Ըĳ�һ���ļ�
//		System.setIn(new FileInputStream("D:\\Java\\TransStreamDemo2.txt"));
		//�޸�Ĭ�ϵĿ���̨Ŀ�ģ�Ҳ���Ըĳ�һ���ļ�
//		System.setOut(new PrintStream("D:\\Java\\TransStreamDemo22.txt"));
		//��������ͬʱʹ�þ����ļ��ĸ���
		
		
		//���̵����д��
		//���� 1
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//���� 2
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Java\\TransStreamDemo2.txt")));
		
		//���� 3
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Java\\TransStreamDemo2.txt")));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line.toString());
			bufw.newLine();//newLine()ֻ��BufferedWriter�ķ���
			bufw.flush();
			
		}
		bufr.close();
	}

}
