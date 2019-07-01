package BIXiangDongTV;

import java.io.File;
import java.io.IOException;
/*
 * File类常见的方法;
 * 1，创建
 * 		boolean  createNewFile();在指定位置创建文件，创建成功返回true，如果该文件已经存在，则不创建，返回false。
 * 								和输出流不一样，输出流对象一建立就会创建，而且文件已经存在，则会覆盖。
 * 		boolean mkdir();  创建文件夹
 * 		boolean mkdirs();  创建多级文件夹
 * 
 * 2，删除
 * 		boolean  delete();删除失败返回false
 * 		void  deleteOnExit();在程序退出时删除指定文件
 * 
 * 3，判断
 * 		boolean  exists();判断文件是否存在
 * 		boolean  canExecute()；判断文件是否能执行
 * 		isDirectory());判断文件对象是否是文件夹
 * 		isFile();判断件对象是否是文件
 * 		isAbsolute();判断文件对象路径是否是绝对路径，就算该文件不存在，只要是绝对路径，就返回true。
 * 
 * 4，获取信息
 * 		String  getName();获取文件对象名称
 * 		String  getPatn();获取文件对象的相对路径
 * 		String getParent();获取文件对象的绝对路径中的父目录路径名称
 * 		String getAbsolutePath();获取文件对象的绝对路径
 * 		long  lastModified();返回文件最后一次的修改时间
 * 		long  length();获取文件的长度大小
 * 
 * 		boolean  renameTo(File f);//将文件f1的名称和路径修改为f2定义的。修改成功返回true，否则返回false
 * 
 */
public class FileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		consMethod();
//		method_1();
		method_2();
//		method_3();
//		method_4();
//		method_5();
	}
	
	public static void method_5() throws IOException
	{
		File f1 = new File("D:\\Java\\FileDemo.txt");
		File f2 = new File("D:\\Java\\FileDemo2.txt");
		
		sop("rename:"+f1.renameTo(f2));//将文件f1的名称和路径修改为f2定义的。
	}
	
	public static void method_4() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt");
		
		sop("path:"+f.getPath());//返回相对路径，即文件路径封装的路径
		sop("abspath:"+f.getAbsolutePath());//返回绝对路径
		sop("parent:"+f.getParent());//该方法返回的时绝对路径中的文件父目录，若果获取的时相对路径，则返回null
									//如果相对路径中有上一层目录，那么该目录就是返回结果。
		
	}
	
	public static void method_1() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt"); 
		f.deleteOnExit();//就算是抛出异常再程序结束时也会强制删除
//			code();//假设此处有一堆对文件进行处理的代码块，
//		sop("create:"+f.createNewFile());
		sop("delete；"+f.delete());
	}
	
	public static void method_2() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt");
		
//		sop("canExcute:"+f.canExecute());//判断文件是否能执行
		sop("exists:"+f.exists());//判断文件是否存在
		
		//创建文件夹
//		File dir = new File("D:\\Java\\bilaoshi");
//		
//		sop("mkdir:"+dir.mkdir());//.mkdir()只能创建一级文件夹
		
		File dir1 = new File("D:\\Java\\bilaoshi\\aa\\bb");
		
		sop("mkdir:"+dir1.mkdirs());//.mkdirs()创建多级文件夹
	}
	
	public static void method_3() throws IOException
	{
		File f = new File("D:\\Java\\FileDemo.txt");
		
//		f.createNewFile();
		
//		f.mkdir();
		
		//切记：在判断文件对象是否是文件或者文件夹时，必须要先判断该文件对象封装的内容是否存在
		//通过exists()方法来进行判断
		sop("dir:"+f.isDirectory());//判断指定路径文件是否是文件夹
		sop("file:"+f.isFile());//判断指定路径文件对象是否是文件
		sop(f.isAbsolute());//判断文件对象路径是否是绝对路径
	}
	
	
	
	
	//创建File对象
	public static void consMethod()
	{
		//将FileDemo.txt封装成file对象。可以将已有的和未出现的文件或者文件夹封装成对象
		File f1 = new File("D:\\Java\\FileDemo.txt");
		
		File f2 = new File("D:\\Java\\毕向东视频","FileDemo.txt");
		
		File d = new File("D:\\Java\\毕向东视频");
		File f3 = new File(d,"FileDemo.txt");
		
		sop("f1:"+f1);
		sop("f2:"+f2);
		sop("f3:"+f3);
		
		//跨平台使用的分割符File.separator，相当于Windows里的"\"
		File f4 = new File("D:"+File.separator+"Java"+File.separator+"毕向东视频"+File.separator+"FileDemo.txt");
	}
	
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}

}
