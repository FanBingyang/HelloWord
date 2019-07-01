package BIXiangDongTV;

import java.io.IOException;
import java.io.InputStream;

/*
 * 读取键盘录入。
 * System.out:对应的是标准的输出设备：控制台。
 * System.in:对应的是标准的输入设备：键盘。
 * 
 * 需求：当录入一行数据后，就将该数据进行打印。
 * 如果录入的数据是over，那么将停止录入。
 */
public class ReadIn {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		InputStream in = System.in; //读取从键盘录入的数据
//		int by = in.read();
//		System.out.println(by);
		
		InputStream in = System.in;//读取从键盘录入的数据
		StringBuilder sb =new  StringBuilder();
		
		while(true)
		{
			int ch = in.read();
			if(ch=='\r')
				continue;
			if(ch=='\n')
			{
				String s = sb.toString();
				if("over".equals(s))
					break;
				System.out.println(s.toUpperCase());//输出大写格式
				sb.delete(0,sb.length());//清空缓冲区，删除从0到sb.length()的数据，
			}
			else
				sb.append((char)ch);
		}
	}

}
