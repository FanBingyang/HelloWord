package BIXiangDongTV;

import java.io.FileReader;

/*
 * 第二种读取方式：通过字符数组进行读取*/
public class FileReaderDemo2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		 
		//定义一个字符数组，用于储存读到的字符
		//该read(char[])返回的是读到的字符个数
		char[] buf = new char[1024];  //数组大小一般定义为1024的整数倍。
	/*	 int num = fr.read(buf);
		 
		 System.out.println("num="+num+"..."+new String(buf));
	*/
		
		int num = 0;
		while((num=fr.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,num));//读到几个就打印出来几个
		/*
		 * public String(char[] value,
              int offset,
              int count)分配一个新的 String，它包含取自字符数组参数一个子数组的字符。
              offset 参数是子数组第一个字符的索引，count 参数指定子数组的长度。
 			   该子数组的内容已被复制；后续对字符数组的修改不会影响新创建的字符串。
		参数：
		value - 作为字符源的数组。
		offset - 初始偏移量。
		count - 长度。
		 */
		}
		 fr.close();
	}

}
