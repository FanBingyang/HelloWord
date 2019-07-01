package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
 * 字符流：
 * FileReader
 * FileWriter
 * 
 * BufferedReader  -|________\ 提高效率
 * BufferedWriter  -|        /
 * 
 * 字节流:
 * FileInputStream  
 * FileOutputStream
 * 
 * BufferedInputStream  
 * BufferedOutputStream
 * 
 * 
 * 通过ReadIn键盘录入一行数据并打印其大写，发现其实就是读取一行(readLine)数据的原理。
 * 能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢 ?
 * 
 * readLine方法是字符流BufferedReader类中的方法。
 * 而键盘录入的read方法是字节流InputStream的方法。
 * 
 * 那么能不能将字节流转成字符流，然后再使用字符流缓冲区的readLine方法呢 ？
 * 
 */
public class TransStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//获取键盘录入对象
//		InputStream in = System.in;
		
		//将字节流转换成字符流对象，使用转换流，InputStreamReader
//		InputStreamReader isr  = new InputStreamReader(in);
		
		//为了提高效率，将字符串进行缓冲区技术高校操作，使用BufferedReader
//		BufferedReader bufr = new BufferedReader(isr);
		
		//这一行代码等价于上面的三行代码
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
//		OutputStream out = System.out;
//		OutputStreamWriter osw = new OutputStreamWriter(out);
//		BufferedWriter bufw = new BufferedWriter(osw);
		
		//这一行代码等价于上面的三行代码****重点****
		//键盘录入最常见写法，
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
//			System.out.println(line.toUpperCase());
			bufw.write(line.toUpperCase());
			bufw.newLine();//newLine()只是BufferedWriter的方法
			bufw.flush();
			
		}
		bufr.close();
	}

}
