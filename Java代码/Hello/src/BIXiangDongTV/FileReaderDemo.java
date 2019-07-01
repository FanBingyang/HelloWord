package BIXiangDongTV;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		try{
			//创建一个文件读取流对象，和指定名称的文件相关联
			//要保证该文件时已经存在的，如果不存在，则会发生FileNotFoundException异常
			fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
			
			
			//调用读取流对象的read方法
			//read():一次读取一个字符，而且会自动往下读
	/*		int ch = fr.read();
			System.out.println("ch="+(char)ch);
			
			int ch1 = fr.read();
			System.out.println("ch="+(char)ch1);
			
			int ch2 = fr.read();
			System.out.println("ch="+(char)ch2);
			
			int ch3 = fr.read();
			System.out.println("ch="+(char)ch3);
			
			int ch4 = fr.read();
			System.out.println("ch="+ch4);//如果读到文件数据末尾，则返回 -1;
		*/
			
		/*	while(true)
			{
				int ch = fr.read();
				if(ch==-1)
					break;
				System.out.println("ch="+(char)ch);
			}
		*/
			
			int ch = 0;
			while((ch=fr.read())!=-1)
			{
				System.out.println("ch="+(char)ch);
			}
			
		}catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				if(fr!=null)
					fr.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		
	}

}
}
