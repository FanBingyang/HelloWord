package BIXiangDongTV;

import java.io.FileReader;
import java.io.IOException;

public class MyLineNumberReadereDemo {
	public static void main(String[] args)throws IOException {
		FileReader fr = new FileReader("D:\\Java\\Buffer.txt");
		MyLineNumberReader mylnr = new MyLineNumberReader(fr);
		
		String line = null;
		mylnr.setLineNumber(100);
		while((line=mylnr.myReadLine())!=null)
		{
			System.out.println(mylnr.getLineNumber()+":"+line);
		}
		mylnr.myClose();
	}
}
