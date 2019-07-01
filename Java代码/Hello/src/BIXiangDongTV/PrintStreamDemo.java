package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * 打印流:
 * 该流提供了打印方法，可以将各种数据类型的数据都原样打印出来。
 * 
 * 字节打印流：
 * PrintStream
 * 构造函数可以接收的参数类型：
 * 1，file对象。File
 * 2，字符串路径。String
 * 3，字节输入流。OutputStream
 * 
 * 
 * 
 * 字符打印流
 * PrintWriter
 * 构造函数可以接收的参数类型：
 * 1，file对象。File
 * 2，字符串路径。String
 * 3，字节输入流。OutputStream
 * 4，字符输出流。Writer。
 */
public class PrintStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("D:\\Java\\PrintStreamDemo.txt")),true);
		
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			out.println(line.toString());
//			out.flush();
		}
		
		out.close();
		bufr.close();
	}

}
