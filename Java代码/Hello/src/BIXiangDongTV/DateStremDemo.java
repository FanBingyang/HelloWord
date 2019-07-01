package BIXiangDongTV;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.DebugGraphics;

/*
 * 可以用于操作基本数据类型得数据流对象
 */
public class DateStremDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		writeData();
//		readeData();
//		weiteUTFDemo();
		
//		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\Java\\gbk.txt"),"gbk");
//		
//		osw.write("你好");
//		osw.close();
		
		readUTFDemo();
	}
	public static void readUTFDemo() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("D:\\Java\\utfdata.txt"));
		String s= dis.readUTF();
		System.out.println(s);
		
		dis.close();
	}
	public static void weiteUTFDemo() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\Java\\utfdata.txt"));
		dos.writeUTF("你好");
		dos.close();
	}
	public static void readeData() throws IOException
	{
		DataInputStream dis = new DataInputStream(new FileInputStream("D:\\Java\\data.txt"));
		int num = dis.readInt();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();
		
		System.out.println("num="+num);
		System.out.println("b="+b);
		System.out.println("d="+d);
	}
	public static void writeData() throws IOException
	{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\Java\\data.txt"));
		dos.writeInt(234);
		dos.writeBoolean(true);
		dos.writeDouble(9887.543);
		dos.close();
	}

}
