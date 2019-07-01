package BIXiangDongTV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.management.RuntimeErrorException;

/*
 * ��ϰ����C�̵�һ���ı��ļ����Ƶ�D�̡�
 * 
 * ���Ƶ�ԭ��
 * ��ʵ���ǽ�C���µ��ļ����ݴ��浽D�̵�һ���ļ��С�
 * 
 * ���裺
 * 1����D�̴���һ���ļ������ڴ���C���ļ��е����ݡ�
 * 2�������ȡ����C���ļ�������
 * 3��ͨ�����ϵĶ�д������ݵĴ洢��
 * 4���ر���Դ��
 */
public class CopyText {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		copy_1();
		copy_2();
	}
	
	//��C�̶�һ���ַ�������D��дһ���ַ�
	public static void copy_1() throws Exception
	{
		//����Ŀ�ĵ�
		FileWriter fw = new FileWriter("D:\\Java\\������Ƶ\\copy_1FielWriterDemo.txt");
		
		//�������ļ�����
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		
		int ch = 0;
		while((ch=fr.read())!=-1)
		{
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}
	
	
	public static void copy_2()
	{
		FileWriter fw = null;
		FileReader fr = null;
		try{
			fw = new FileWriter("D:\\Java\\������Ƶ\\copy_2FielWriterDemo2.txt");
			fr = new FileReader("D:\\Java\\FielWriterDemo2.txt");
			
			char[] buf = new char[1024];
			int len = 0;
			
			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
				/*
				  public abstract void write(char[] cbuf,int off,int len)throws IOExceptionд���ַ������ĳһ���֡� 
				������
				cbuf - �ַ�����
				off - ��ʼд���ַ�����ƫ����,��ʼ��
				len - Ҫд����ַ�
				 */
			}
		}
		catch(IOException e)
			{
				throw new RuntimeException("��дʧ��!");
			}
		finally{
			if(fr!=null)
				try{
					fr.close();
				}catch(IOException e){
					System.out.println(e.toString());
				}
			if(fw!=null)
				try{
					fw.close();
				}catch(IOException e){
					System.out.println(e.toString());
				}
		}
		
	}
	

}
