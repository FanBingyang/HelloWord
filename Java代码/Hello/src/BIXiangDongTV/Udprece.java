package BIXiangDongTV;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * ����
 * ����һ��Ӧ�ó������ڽ���udpЭ�鴫������ݲ�����
 * 
 * ����udp�Ľ��ն�
 * ˼·��
 * 1������udosocket����ͨ�������һ���˿ڣ���ʵ���Ǹ������������Ӧ�ó��������ݱ�ʶ��
 * 	��������ȷ��Щ���ݹ�����Ӧ�ó�����Դ���
 * 2������һ�����ݰ�����ΪҪ�洢���յ����ֽ�����
 * ��Ϊ���ݰ��������и��๦�ܿ�����ȡ�ֽ������еĲ�ͬ������Ϣ
 * 3��ͨ��socket�����receive�ķ��������յ������ݴ����Ѷ���õ����ݰ���
 * 4��ͨ�����ݰ���������й��ܣ�����Щ��ͬ������ȡ������ӡ�ڿ���̨�ϡ�
 * 5���ر���Դ 
 */
public class Udprece {

	public static void main(String[] args) throws Exception {
		// TODO �Զ����ɵķ������
		//1,����udpsocket�������˵�
		DatagramSocket ds = new DatagramSocket(10001);
		while(true)  //���ֽ��ն�ʼ�տ���
		{
			//2���������ݰ������ڴ洢����
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			
			//3��ͨ�������receive���������յ������ݴ������ݰ���
			ds.receive(dp); //����ʽ����
			
			//4��ͨ�����ݰ��ķ�����ȡ���е�����
			String ip = dp.getAddress().getHostAddress();
			String data = new String(dp.getData(),0,dp.getLength());
			int port = dp.getPort();	
			
			System.out.println(ip+"::"+data+"::"+port);
			
			
		}
		//5���ر���Դ
//		ds.close();
		
	}

}
