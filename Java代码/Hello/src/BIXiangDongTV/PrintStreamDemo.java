package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * ��ӡ��:
 * �����ṩ�˴�ӡ���������Խ������������͵����ݶ�ԭ����ӡ������
 * 
 * �ֽڴ�ӡ����
 * PrintStream
 * ���캯�����Խ��յĲ������ͣ�
 * 1��file����File
 * 2���ַ���·����String
 * 3���ֽ���������OutputStream
 * 
 * 
 * 
 * �ַ���ӡ��
 * PrintWriter
 * ���캯�����Խ��յĲ������ͣ�
 * 1��file����File
 * 2���ַ���·����String
 * 3���ֽ���������OutputStream
 * 4���ַ��������Writer��
 */
public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Java\\PrintStreamDemo.txt")),true);
		
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			out.println(line.toString());
//			out.flush();
		}
		
		out.close();
		bufr.close();
	}

}
