package BIXiangDongTV;

import java.io.FileWriter;
import java.io.IOException;

import org.omg.CORBA.PRIVATE_MEMBER;

/*
 * IO�쳣�Ĵ���ʽ
 * */
public class FielWriterDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try{
			fw = new FileWriter("D:\\Java\\FielWriterDemo2.txt");
			
			fw.write("abcdefdg\r\n"
					+ "һ��Ҫ���ļ������жϣ���Ϊ����ļ���ʼ��ʧ�ܣ��ô����׳���ָ���쳣���������ļ����͹رռ���");
			
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				//һ��Ҫ���ļ������жϣ���Ϊ����ļ���ʼ��ʧ�ܣ��ô����׳���ָ���쳣���������ļ����͹رռ���
				if(fw!=null)
					fw.close();
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}

}
