package BIXiangDongTV;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 字符流和字节流：
 * 
 * 字节流两个基类：
 * InputStream  OutputStream
 * 
 * 
 * 字符流两个基类：
 * Reader Writer
 * 
 * 先学习一下字符流的特点。
 * 既然IO流适用于操作数据的，那么数据最常见的体现形式就是：文件。
 * 
 * 那么就先以操作文件为主来演示。
 * 需求：在硬盘上创建一个文件并写入一些数据
 * 
 * 专门用于操作文件的writer子类对象，FileWriter。后缀名时父类名，前缀名时该流对象的功能。
 * 
 * 
 */
public class FielWriterDemo {

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		//创建一个FileWriter对象，该对象一被初始化就必须要明确被操作的文件。
		
		//而且该文件会被创建到指定目录下。如果该目录下已有同名文件，将被覆盖。
		//其实该步骤就是明确数据要存放的目的地。
		FileWriter fw = new FileWriter("D:\\Java\\FielWriterDemo.txt");
		//调用write方法，将字符串写入到流中。
		fw.write("abcde");
		//刷新流对象中的缓冲数据，将数据刷到目的地中。。
		fw.flush();
		
		fw.write("hahaha");
		fw.flush();
		
		fw.write("* 字符流和字节流：\r\n* 字节流两个基类：\r\n* InputStream  OutputStream\r\n* "
				+ "\r\n * 字符流两个基类：\r\n * Reader Writer\r\n * \r\n * 先学习一下字符流的特点。\r\n"
				+ "* 既然IO流适用于操作数据的，那么数据最常见的体现形式就是：文件。\r\n"
				+ "*\r\n  * 那么就先以操作文件为主来演示。\r\n"
				+ " * 需求：在硬盘上创建一个文件并写入一些数据\r\n"
				+ "* \r\n* 专门用于操作文件的writer子类对象，FileWriter。后缀名时父类名，前缀名时该流对象的功能\r\n");
			
		
		//关闭流资源，但是关闭之前会刷新一次内部的缓冲中的数据，将数据刷到目的地中，
		//和flush的区别：flush刷新后，流可以继续使用，close刷新后，会将流关闭。
		fw.close();
		
		
		
		
	}

}
