package BIXiangDongTV;

import java.io.FileWriter;
import java.io.IOException;

import org.omg.CORBA.PRIVATE_MEMBER;

/*
 * IO异常的处理方式
 * */
public class FielWriterDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		try{
			fw = new FileWriter("D:\\Java\\FielWriterDemo2.txt");
			
			fw.write("abcdefdg\r\n"
					+ "一定要对文件进行判断，因为如果文件初始化失败，该处会抛出空指针异常，开几个文件流就关闭几次");
			
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally
		{
			try
			{
				//一定要对文件进行判断，因为如果文件初始化失败，该处会抛出空指针异常，开几个文件流就关闭几次
				if(fw!=null)
					fw.close();
			}
			catch(IOException e)
			{
				System.out.println(e.toString());
			}
		}
	}

}
