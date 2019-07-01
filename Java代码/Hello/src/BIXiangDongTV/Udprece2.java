package BIXiangDongTV;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Udprece2 {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		DatagramSocket ds = new DatagramSocket(10002);
		while(true)
		{
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			
			String ip =dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			
			System.out.println(ip+"::"+data);
		}
	}

}
