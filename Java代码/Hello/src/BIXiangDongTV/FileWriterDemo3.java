package BIXiangDongTV;

import java.io.FileWriter;
import java.io.IOException;

/*
 * 演示对已有文件的数据续写。
 * */
public class FileWriterDemo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw = null;
		//传递一个true参数，代表不覆盖已有的文件，并在已有文件的末尾处进行数据续写
		try{
			fw = new FileWriter("D:\\Java\\FileWriterDemo3.txt",true);
			//在windows里的记事本里，\r\n才是换行符，
			fw.write(" hello\r\nhaha");
			
		}catch(IOException e){
			System.out.println(e.toString());
		}
		finally{
			try{
				if(fw!=null)
					fw.close();
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}

}
