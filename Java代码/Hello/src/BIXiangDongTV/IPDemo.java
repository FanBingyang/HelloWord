package BIXiangDongTV;

import java.io.IOException;
import java.net.InetAddress;

public class IPDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//����ָ����������������ȡ����������ip��ַ
		InetAddress i = InetAddress.getLocalHost();
		System.out.println(i.toString());
		System.out.println("address:"+i.getHostAddress());
		System.out.println("name:"+i.getHostName());
		
		//����ָ��ip����������ȡ����������ip��ַ
//		InetAddress ia = InetAddress.getByName("www.baidu.com");
		InetAddress ia = InetAddress.getByName("10.85.16.12");
		System.out.println("address:"+ia.getHostAddress());
		System.out.println("name:"+ia.getHostName());

		
		
	}

}
