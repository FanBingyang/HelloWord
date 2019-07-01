package BIXiangDongTV;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 异常日志的信息
 */
public class ExceptionInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int[] arr = new int[2];
			System.out.println(arr[3]);
		} catch (Exception e) {
			// TODO: handle exception
			try {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				String s = sdf.format(d);
				
				PrintStream ps = new PrintStream("D:\\Java\\ExceptionInfo.txt");
				ps.println(s);
				System.setOut(ps);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException("日志文件创建失败");
			}  
			e.printStackTrace(System.out);
		}
	}

}
//log4j  建立日志信息的包，自行下载