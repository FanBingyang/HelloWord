package BIXiangDongTV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * ���಻����IO��ϵ������
 * ����ֱ�Ӽ̳���Object 
 * 
 * ������ʱIO���ĳ�Ա����Ϊ���߱�����д����
 * �ڲ���װ��һ�����飬����ͨ��ָ��������Ԫ�ؽ��в���
 * ����ͨ��getFilePointer��ȡָ��λ��
 * ͬʱ����ͨ��seek�ı�ָ���λ��
 * 
 * ��ʵ��ɶ���д��ԭ������ڲ���װ�����ֽ��������������
 * 
 * ͨ�����캯�����Կ���������ֻ�ܲ����ļ���
 * ���һ��в����ļ���ģʽ:ֻ����'r'����д'rw'
 * 
 * ���ģʽΪ r �����ᴴ���ļ�����ȥ��ȡһ���Ѵ��ٵ��ļ���������ļ��������������쳣
 * ���ģʽΪ rw ����ô�������ļ������ڣ����Զ����������������Ḳ��
 */
public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		writefile();
		readFile();
		writefile_2();
	}
	public static void readFile() throws IOException
	{
		
		RandomAccessFile raf = new RandomAccessFile("D:\\Java\\ran.txt","r");
		
		//����������ָ��
//		raf.seek(8);//ֱ��ȡ���ڶ�����
		
		//����ָ�����ֽ���,ֻ��������
//		raf.skipBytes(8);
		
		
		byte[] buf = new byte[4];
		
		raf.read(buf);
		
		String name = new String(buf);
		System.out.println("name="+name);
		int age = raf.readInt();
		System.out.println("age="+age);
		raf.close();
	}
	
	public static void writefile_2() throws IOException
	{
		
		RandomAccessFile raf = new RandomAccessFile("D:\\Java\\ran.txt","rw");
		raf.seek(8*3);
		raf.write("zhouqi".getBytes());
		raf.writeInt(108);
	}
	
	public static void writefile() throws IOException
	{
		RandomAccessFile raf = new RandomAccessFile("D:\\Java\\ran.txt","rw");
		raf.write("lisi".getBytes());
		raf.writeInt(97);
		raf.write("wangwu".getBytes());
		raf.writeInt(99);
		
		raf.close();
	}

}
