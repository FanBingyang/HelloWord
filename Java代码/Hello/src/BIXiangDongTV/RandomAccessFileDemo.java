package BIXiangDongTV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 该类不算是IO体系中子类
 * 而是直接继承自Object 
 * 
 * 但是它时IO包的成员，因为它具备读和写功能
 * 内部封装了一个数组，而且通过指针对数组的元素进行操作
 * 可以通过getFilePointer获取指针位置
 * 同时可以通过seek改变指针的位置
 * 
 * 其实完成读和写的原理就是内部封装来了字节输入流和输出流
 * 
 * 通过构造函数可以看出，该类只能操作文件。
 * 而且还有操作文件的模式:只读：'r'，读写'rw'
 * 
 * 如果模式为 r ，不会创建文件，会去读取一个已存再得文件，如果该文件不存在则会出现异常
 * 如果模式为 rw ，那么操作的文件不存在，会自动创建，如果存在则会覆盖
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
		
		//调整对象中指针
//		raf.seek(8);//直接取出第二个人
		
		//跳过指定的字节数,只能往后跳
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
