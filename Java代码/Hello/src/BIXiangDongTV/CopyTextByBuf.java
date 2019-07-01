package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 通过缓冲区复制一个.java文件.
 * readLine()方法返回的时候只返回回车符之前的数据内容，并不返回回车符。
 */
public class CopyTextByBuf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//建立对象引用
		BufferedReader bufr = null;
		BufferedWriter bufw = null;
		try{
			bufr = new BufferedReader(new FileReader("\\Java\\Buffer.txt"));
			bufw = new BufferedWriter(new FileWriter("\\Java\\毕向东视频\\Copy_Buffer.txt"));
			
			String line = null;
			while((line=bufr.readLine())!=null)//readLine()返回包含内容的字符串，不包含终止符
			{
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
			bufr.close();
		}catch(IOException e)
		{
			throw new RuntimeException("读写失败");
		}
		finally{
			try{
				if(bufr!=null)
					bufr.close();
			}catch(IOException e)
			{
				throw new RuntimeException("读取关闭失败！");
			}
			try{
				if(bufw!=null)
					bufw.close();
			}catch(IOException e)
			{
				throw new RuntimeException("写入关闭失败！");
			}
		}
		
	}

}
