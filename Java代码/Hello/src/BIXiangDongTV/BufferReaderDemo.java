package BIXiangDongTV;
/*
 * �ַ���ȡ��������
 * 
 * �û������ṩ��һ��һ�ζ�һ�еķ���readLine()�������ڶ��ı����ݵĻ�ȡ��
 * ������nullʱ����ʾ�����ļ�ĩβ��
 */
import java.io.BufferedReader;
import java.io.FileReader;

public class BufferReaderDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//����һ����ȡ��������ļ��������
		FileReader fr = new FileReader("D:\\Java\\Buffer.txt");
		//Ϊ�����Ч�ʣ����뻺�弼�������ַ���ȡ��������Ϊ�������ݸ��������Ĺ��캯����
		BufferedReader bufr = new BufferedReader(fr);
		
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			System.out.println(line);
		}
		
		
		bufr.close();
	}

}
