package BIXiangDongTV;

import java.io.FileWriter;
import java.io.IOException;

/*
 * ��ʾ�������ļ���������д��
 * */
public class FileWriterDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		//����һ��true�����������������е��ļ������������ļ���ĩβ������������д
		try{
			fw = new FileWriter("D:\\Java\\FileWriterDemo3.txt",true);
			//��windows��ļ��±��\r\n���ǻ��з���
			fw.write(" hello\r\nhaha");
			
		}catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				if(fw!=null)
					fw.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}

}
