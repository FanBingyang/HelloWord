package BIXiangDongTV;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * ����ͨ��udp���䷽ʽ����һ�����ַ��ͳ�ȥ
 * ˼·��
 * 1������udpsocket����
 * 2���ṩ���ݣ��������ݷ�װ�����ݰ���
 * 3��ͨ��socket����ķ��͹��ܣ������ݰ� ���ͳ�ȥ
 * 4���ر���Դ
 */
public class UdpSend {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1������udpsocket����ͨ��DatagramPacket��������
		DatagramSocket ds = new DatagramSocket();
		
		//2��ȷ�����ݣ�����װ�����ݰ�
		byte[] buf = "udp ge men lai le".getBytes();
		DatagramPacket dp = 
				new DatagramPacket(buf, buf.length,InetAddress.getByName("10.62.24.157"),10001);
		
		//3��ͨ��socket���񣬽��������ݰ����ͳ�ȥ��ͨ��send����
		ds.send(dp);
		
		//4���ر���Դ
		ds.close();
		
 	}

}
