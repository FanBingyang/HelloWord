package BIXiangDongTV;

import java.io.FileWriter;
import java.io.IOException;

/*
 * �ַ������ֽ�����
 * 
 * �ֽ����������ࣺ
 * InputStream  OutputStream
 * 
 * 
 * �ַ����������ࣺ
 * Reader Writer
 * 
 * ��ѧϰһ���ַ������ص㡣
 * ��ȻIO�������ڲ������ݵģ���ô���������������ʽ���ǣ��ļ���
 * 
 * ��ô�����Բ����ļ�Ϊ������ʾ��
 * ������Ӳ���ϴ���һ���ļ���д��һЩ����
 * 
 * ר�����ڲ����ļ���writer�������FileWriter����׺��ʱ��������ǰ׺��ʱ��������Ĺ��ܡ�
 * 
 * 
 */
public class FielWriterDemo {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//����һ��FileWriter���󣬸ö���һ����ʼ���ͱ���Ҫ��ȷ���������ļ���
		
		//���Ҹ��ļ��ᱻ������ָ��Ŀ¼�¡������Ŀ¼������ͬ���ļ����������ǡ�
		//��ʵ�ò��������ȷ����Ҫ��ŵ�Ŀ�ĵء�
		FileWriter fw = new FileWriter("D:\\Java\\FielWriterDemo.txt");
		//����write���������ַ���д�뵽���С�
		fw.write("abcde");
		//ˢ���������еĻ������ݣ�������ˢ��Ŀ�ĵ��С���
		fw.flush();
		
		fw.write("hahaha");
		fw.flush();
		
		fw.write("* �ַ������ֽ�����\r\n* �ֽ����������ࣺ\r\n* InputStream  OutputStream\r\n* "
				+ "\r\n * �ַ����������ࣺ\r\n * Reader Writer\r\n * \r\n * ��ѧϰһ���ַ������ص㡣\r\n"
				+ "* ��ȻIO�������ڲ������ݵģ���ô���������������ʽ���ǣ��ļ���\r\n"
				+ "*\r\n  * ��ô�����Բ����ļ�Ϊ������ʾ��\r\n"
				+ " * ������Ӳ���ϴ���һ���ļ���д��һЩ����\r\n"
				+ "* \r\n* ר�����ڲ����ļ���writer�������FileWriter����׺��ʱ��������ǰ׺��ʱ��������Ĺ���\r\n");
			
		
		//�ر�����Դ�����ǹر�֮ǰ��ˢ��һ���ڲ��Ļ����е����ݣ�������ˢ��Ŀ�ĵ��У�
		//��flush������flushˢ�º������Լ���ʹ�ã�closeˢ�º󣬻Ὣ���رա�
		fw.close();
		
		
		
		
	}

}
