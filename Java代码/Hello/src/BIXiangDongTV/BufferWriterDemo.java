package BIXiangDongTV;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * 缓冲区的出现是为了提高流的操作数据而出现的
 * 所以，在创建缓冲区之前，必须要先有流对象。
 * 
 * 该缓冲区中提供了一个跨平台的换行符。
 * newLine();
 */
public class BufferWriterDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//创建一个字符写入流对象
		FileWriter fw = new FileWriter("D:\\Java\\Buffer.txt");
		
		//为了提高字符写入流的效率，加入了缓冲技术
		//只要将需要的被提高效率的流对象最为参数传递给缓冲区的构造函数即可。
		BufferedWriter bufw = new BufferedWriter(fw);
		for(int x=1;x<5;x++)
		{
			bufw.write("abcd--"+x);
			bufw.newLine();//跨平台使用的换行符。
			bufw.flush();
		}
		
		
		//记住:只要用到 缓冲技术，就要刷新。
//		bufw.flush();
		//其实关闭缓冲区就是在关闭缓冲区中的流对象
		bufw.close();
		//
	}

}
