package BIXiangDongTV;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.management.RuntimeErrorException;

/*
 * 练习：将C盘的一个文本文件复制到D盘。
 * 
 * 复制的原理：
 * 其实就是将C盘下的文件数据储存到D盘的一个文件中。
 * 
 * 步骤：
 * 1，在D盘创建一个文件，用于储存C盘文件中的数据。
 * 2，定义读取流和C盘文件关联。
 * 3，通过不断的读写完成数据的存储。
 * 4，关闭资源。
 */
public class CopyText {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		copy_1();
		copy_2();
	}
	
	//从C盘读一个字符，就往D盘写一个字符
	public static void copy_1() throws Exception
	{
		//创建目的地
		FileWriter fw = new FileWriter("D:\\Java\\毕向东视频\\copy_1FielWriterDemo.txt");
		
		//与已有文件关联
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		
		int ch = 0;
		while((ch=fr.read())!=-1)
		{
			fw.write(ch);
		}
		fw.close();
		fr.close();
	}
	
	
	public static void copy_2()
	{
		FileWriter fw = null;
		FileReader fr = null;
		try{
			fw = new FileWriter("D:\\Java\\毕向东视频\\copy_2FielWriterDemo2.txt");
			fr = new FileReader("D:\\Java\\FielWriterDemo2.txt");
			
			char[] buf = new char[1024];
			int len = 0;
			
			while((len=fr.read(buf))!=-1)
			{
				fw.write(buf,0,len);
				/*
				  public abstract void write(char[] cbuf,int off,int len)throws IOException写入字符数组的某一部分。 
				参数：
				cbuf - 字符数组
				off - 开始写入字符处的偏移量,开始处
				len - 要写入的字符
				 */
			}
		}
		catch(IOException e)
			{
				throw new RuntimeException("读写失败!");
			}
		finally{
			if(fr!=null)
				try{
					fr.close();
				}catch(IOException e){
					System.out.println(e.toString());
				}
			if(fw!=null)
				try{
					fw.close();
				}catch(IOException e){
					System.out.println(e.toString());
				}
		}
		
	}
	

}
