package BIXiangDongTV;

import java.io.FileReader;

public class MyBufferedReaderDemo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		
		MyBufferedReader myBuf = new MyBufferedReader(fr);
		
		String line = null;
		while((line=myBuf.myReaderLine())!=null)
		{
			System.out.println(line);
		}
		myBuf.myClose();
	}

}
