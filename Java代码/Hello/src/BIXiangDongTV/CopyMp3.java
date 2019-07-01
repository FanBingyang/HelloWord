package BIXiangDongTV;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
/*
 * 复制一个Mp3文件，通过缓冲区。
 */
public class CopyMp3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		copy_2();
		long end = System.currentTimeMillis();
		
		System.out.println((end-start)+"毫秒");
	}
	
	public static void copy_2()throws IOException
	{
		MyBufferedInputStream bufis = new MyBufferedInputStream(new FileInputStream("D:\\Java\\绅士.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("D:\\Java\\绅士copy.mp3"));
		
		int by = 0;
		while((by=bufis.myRead())!=-1)
		{
			bufos.write(by);
		}
		
		bufis.myClose();
		bufos.close();
	}
	//通过字节流的缓冲区完成复制
	public static void copy_1()throws IOException
	{
		BufferedInputStream bufis = new BufferedInputStream(new FileInputStream("D:\\Java\\绅士.mp3"));
		BufferedOutputStream bufos = new BufferedOutputStream(new FileOutputStream("D:\\Java\\绅士copy.mp3"));
		
		int by = 0;
		while((by=bufis.read())!=-1)
		{
			bufos.write(by);
		}
		
		bufis.close();
		bufos.close();
	}
}
