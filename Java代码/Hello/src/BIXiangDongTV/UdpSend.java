package BIXiangDongTV;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 需求：通过udp传输方式，讲一段文字发送出去
 * 思路：
 * 1，建立udpsocket服务
 * 2，提供数据，并将数据封装到数据包中
 * 3，通过socket服务的发送功能，将数据包 发送出去
 * 4，关闭资源
 */
public class UdpSend {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1，建立udpsocket服务，通过DatagramPacket创建对象
		DatagramSocket ds = new DatagramSocket();
		
		//2，确定数据，并封装成数据包
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = 
				new DatagramPacket(buf, buf.length,InetAddress.getByName("10.62.24.157"),10001);
		
		//3，通过socket服务，将已有数据包发送出去，通过send方法
		ds.send(dp);
		
		//4，关闭资源
		ds.close();
		
 	}

}
