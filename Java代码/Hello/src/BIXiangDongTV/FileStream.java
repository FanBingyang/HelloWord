package BIXiangDongTV;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 字符流：
 * FileReader
 * FileWriter
 * 
 * BufferedReader
 * BufferedWriter
 * 
 * 字节流:
 * InputStream  OutputStream
 * 
 * 需求：想要操作图片数据，这时就要用到字节流
 */
public class FileStream {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		writeFile();
//		readFile_1();
//		readFile_2();
		readFile_3();
	}
	
	public static void readFile_3() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Java\\FileStream.txt");
		
//		int num = fis.available();//返回文件中的字节个数
//		System.out.println("num="+num);
		
		byte[] buf = new byte[fis.available()];//定义一个空间刚刚好的缓冲区，不用再循环了。
											//建议小数据文件使用，大数据的文件不建议使用，因为虚拟机启动时是64M的内存，
											//定义的数组过大的话虚拟机会崩溃。第二种方法是折中的方法。
		fis.read(buf);
		System.out.println(new String(buf));
		
		fis.close();
		
	}
	public static void readFile_2() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Java\\FileStream.txt");
		
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=fis.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,len));
		}
		fis.close();
	}
	public static void readFile_1() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Java\\FileStream.txt");
		
		int ch = 0;
		while((ch=fis.read())!=-1)
		{
			System.out.println("ch="+(char)ch);
		}
		fis.close();
	}
	public static void writeFile() throws IOException
	{
		FileOutputStream fos = new FileOutputStream("D:\\Java\\FileStream.txt");
		
		fos.write("abcde".getBytes());//将字符串转成字节数组
		
		fos.close();
		
		
	}

}
