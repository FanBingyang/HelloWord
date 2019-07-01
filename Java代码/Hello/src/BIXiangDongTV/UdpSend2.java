package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSend2 {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		DatagramSocket ds = new DatagramSocket();
		
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		
		while((line=bufr.readLine())!=null)
		{
			if("886".equals(line))
				break;
			byte[] buf = line.getBytes();
			
			DatagramPacket dp = 
					new DatagramPacket(buf, buf.length,InetAddress.getByName("172.20.37.8"),10002);
			ds.send(dp);
		}
		ds.close();
		
		
	}

}
