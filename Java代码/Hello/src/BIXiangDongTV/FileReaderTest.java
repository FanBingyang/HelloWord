package BIXiangDongTV;

import java.io.FileReader;

//��ϰ����ȡһ��.java�ļ�������ӡ�ڿ���̨��
public class FileReaderTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		
		char[] buf = new char[1024];
		int num = 0;
		while((num=fr.read(buf))!=-1){
			System.out.print(new String(buf,0,num));
		}
		
		fr.close();
	}

}
