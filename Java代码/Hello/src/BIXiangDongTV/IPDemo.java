package BIXiangDongTV;

import java.io.IOException;
import java.net.InetAddress;

public class IPDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//访问指定本机的主机，获取其主机名和ip地址
		InetAddress i = InetAddress.getLocalHost();
		System.out.println(i.toString());
		System.out.println("address:"+i.getHostAddress());
		System.out.println("name:"+i.getHostName());
		
		//访问指定ip的主机，获取其主机名和ip地址
//		InetAddress ia = InetAddress.getByName("www.baidu.com");
		InetAddress ia = InetAddress.getByName("10.85.16.12");
		System.out.println("address:"+ia.getHostAddress());
		System.out.println("name:"+ia.getHostName());

		
		
	}

}
