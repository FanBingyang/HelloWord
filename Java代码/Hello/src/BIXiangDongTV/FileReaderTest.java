package BIXiangDongTV;

import java.io.FileReader;

//练习：读取一个.java文件，并打印在控制台上
public class FileReaderTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		
		char[] buf = new char[1024];
		int num = 0;
		while((num=fr.read(buf))!=-1){
			System.out.print(new String(buf,0,num));
		}
		
		fr.close();
	}

}
