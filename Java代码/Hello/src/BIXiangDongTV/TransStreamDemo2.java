package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
/*
 * 1，需求：想把键盘录入的数据的大写打印再控制台。
 * 源：键盘录入
 * 目的：控制台。
 * 
 * 2，需求：想把键盘录入的数据存储到一个文件中
 * 源：键盘
 * 目的：文件
 * 
 * 3，需求：想要将一个文件的数据打印再控制台上。
 * 源:文件。
 * 目的：控制台
 * 
 ********************************************************************
 * 流操所的基本规律：
 * 最痛苦的就是流对象有很多，不知道该用哪一个。
 * 
 * 通过三个明确来完成。
 * 1，明确源和目的。
 * 		源:输入流。InputStream  Reader
 * 		目的:输出流。OutputStream  Writer。
 * 2，明确操作的数据是否是纯文本。
 * 		是：字符流。
 * 		不是：字节流。
 * 3，当体系明确后，再明确要使用哪个具体的对象
 * 		通过设备来进行区分
 * 		源设备：内存，硬盘，键盘
 * 		目的设备：内存，硬盘，控制台
 *  
 ********************************************************************
 *  扩展：
 *  想要把录入的数据按照指定的编码表(utf-8），将数据存到文件上。
 *  存储时若要按照指定的编码表，而指定的编码表只有转换流可以指定。默认的编码表为GBK
 *  所以要用的对象是OutputStreamWriter。
 *  而该转换流对象要接收一个字节输入流，而且还可以操作文件的字节输出流：FileOutputStream
 *  
 *  示例代码：OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d.txt","UTF-8");   "d.txt"是要操作的文件；"UTF-8"指定编码表
 *  																				 
 *  需要高效的示例代码：
 *  BufferedWriter bufw = new BufferedWriter(osw);
 *  
 ****所以：转换流什么时候使用呢？
 *  	字符和字节之间的桥梁，通常，涉及到字符编码转换时，需要用到转换流。
 *  
 * 
 * 
 */
public class TransStreamDemo2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//修改默认的键盘源，可以改成一个文件
//		System.setIn(new FileInputStream("D:\\Java\\TransStreamDemo2.txt"));
		//修改默认的控制台目的，也可以改成一个文件
//		System.setOut(new PrintStream("D:\\Java\\TransStreamDemo22.txt"));
		//以上两个同时使用就是文件的复制
		
		
		//键盘的最常见写法
		//需求 1
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//需求 2
//		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Java\\TransStreamDemo2.txt")));
		
		//需求 3
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\Java\\TransStreamDemo2.txt")));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			bufw.write(line.toString());
			bufw.newLine();//newLine()只是BufferedWriter的方法
			bufw.flush();
			
		}
		bufr.close();
	}

}
