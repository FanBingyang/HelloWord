package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 编写一个聊天程序。
 * 有收数据的部分，和发数据的部分。
 * 这两个部分需要同时执行，那就需要用到多线程技术
 * 一个线程控制接收，要提个线程控制发送
 * 
 * 因为收和发动作是不一致的，所以要定义两个run方法
 * 而且这两个run方法要定义在两个类中
 */
class Send implements Runnable{
	private DatagramSocket ds;

	public Send(DatagramSocket ds)
	{
		this.ds = ds;
	}
	public void run() 
	{
		try {
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
			
			String line = null;
			
			while((line=bufr.readLine())!=null)
			{
				if("886".equals(line))
					break;
				
				byte[] buf = line.getBytes();
				
				DatagramPacket dp = 
						new DatagramPacket(buf, buf.length,InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()),10002);
				ds.send(dp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("发送失败");
		}
	}
}	

class Rece implements Runnable{
	private DatagramSocket ds;

	public Rece(DatagramSocket ds)
	{
		this.ds = ds;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true)
			{
				byte[] buf = new byte[1024];
				
				DatagramPacket dp = new DatagramPacket(buf, buf.length);
				
				ds.receive(dp);
				
				String ip = dp.getAddress().getHostAddress();
				
				String data = new String(dp.getData(),0,dp.getLength());
				
				System.out.println(ip+"："+data);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("接收失败");
		}
	}
}	
public  class ChatDemo{
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub\
		DatagramSocket sendSocket = new DatagramSocket();
		DatagramSocket receSocket = new DatagramSocket(10002);
		
		new Thread(new Send(sendSocket)).start();
		new Thread(new Rece(receSocket)).start();
	}
	
}






