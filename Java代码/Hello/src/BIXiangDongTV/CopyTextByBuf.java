package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ͨ������������һ��.java�ļ�.
 * readLine()�������ص�ʱ��ֻ���ػس���֮ǰ���������ݣ��������ػس�����
 */
public class CopyTextByBuf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������������
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		try{
			bufr = new BufferedReader(new FileReader("\\Java\\Buffer.txt"));
			bufw = new BufferedWriter(new FileWriter("\\Java\\������Ƶ\\Copy_Buffer.txt"));
			
			String line = null;
			while((line=bufr.readLine())!=null)//readLine()���ذ������ݵ��ַ�������������ֹ��
			{
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
			bufr.close();
		}catch(IOException e)
		{
			throw new RuntimeException("��дʧ��");
		}
		finally{
			try{
				if(bufr!=null)
					bufr.close();
			}catch(IOException e)
			{
				throw new RuntimeException("��ȡ�ر�ʧ�ܣ�");
			}
			try{
				if(bufw!=null)
					bufw.close();
			}catch(IOException e)
			{
				throw new RuntimeException("д��ر�ʧ�ܣ�");
			}
		}
		
	}

}
