package BIXiangDongTV;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		try{
			//����һ���ļ���ȡ�����󣬺�ָ�����Ƶ��ļ������
			//Ҫ��֤���ļ�ʱ�Ѿ����ڵģ���������ڣ���ᷢ��FileNotFoundException�쳣
			fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
			
			
			//���ö�ȡ�������read����
			//read():һ�ζ�ȡһ���ַ������һ��Զ����¶�
	/*		int ch = fr.read();
			System.out.println("ch="+(char)ch);
			
			int ch1 = fr.read();
			System.out.println("ch="+(char)ch1);
			
			int ch2 = fr.read();
			System.out.println("ch="+(char)ch2);
			
			int ch3 = fr.read();
			System.out.println("ch="+(char)ch3);
			
			int ch4 = fr.read();
			System.out.println("ch="+ch4);//��������ļ�����ĩβ���򷵻� -1;
		*/
			
		/*	while(true)
			{
				int ch = fr.read();
				if(ch==-1)
					break;
				System.out.println("ch="+(char)ch);
			}
		*/
			
			int ch = 0;
			while((ch=fr.read())!=-1)
			{
				System.out.println("ch="+(char)ch);
			}
			
		}catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				if(fr!=null)
					fr.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		
	}

}
}
