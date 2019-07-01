package BIXiangDongTV;
/*
 * 需求：建立一个文本转换服务器
 * 客户端给服务端发送一个文本，服务端会将文本转换成大写的再返回给客户端
 * 而且客户端可以不断的进行文本的转换，当了客户端输入over时，转换结束
 * 
 * 
 * 分析:
 * 
 * 客户端：
 * 既然是操作设备上的数据，那么就可以用io技术，并按照io的操作规律来思考
 * 源：键盘录入
 * 目的：网络设备，网络输出流
 * 而且操作的是文本数据，可以选择字符流
 * 步骤：
 * 1，建立服务
 * 2，获取键盘录入
 * 3，将数据发给服务端
 * 4，后去服务端返回的大写
 * 5，结束，关闭源。
 * 
 * 都是文本数据，可以使用字符流进行操作，同时提高效率，加入缓冲
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class WenBenZhuanHuan {
	public static void main(String[] args) {
		
	}
}

class TransClient1
{
	public static void main(String[] args) throws Exception {
		Socket s =new Socket("10.85.16.12", 10006);
		
		//定义读取键盘数据对象
		BufferedReader bufr =
				new BufferedReader(new InputStreamReader(System.in));
		
		//定义目的，将数据写入到socket输出流，发送给服务端
		BufferedWriter bufout =	
				new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		//定义一个socket读取数据流，读取服务端返回的大写信息
		BufferedReader bufIn = 
				new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		
		String line = null;
		
		while((line=bufr.readLine())!=null)
		{
			if("over".equals(line))
				break;
			
			bufout.write(line);
			
			String str = bufIn.readLine();
			System.out.println("Sever:"+str);	
		}
		bufr.close();
		s.close();
	}
}


