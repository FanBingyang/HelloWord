package BIXiangDongTV;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * �������ĳ�����Ϊ��������Ĳ������ݶ����ֵ�
 * ���ԣ��ڴ���������֮ǰ������Ҫ����������
 * 
 * �û��������ṩ��һ����ƽ̨�Ļ��з���
 * newLine();
 */
public class BufferWriterDemo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//����һ���ַ�д��������
		FileWriter fw = new FileWriter("D:\\Java\\Buffer.txt");
		
		//Ϊ������ַ�д������Ч�ʣ������˻��弼��
		//ֻҪ����Ҫ�ı����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯�����ɡ�
		BufferedWriter bufw = new BufferedWriter(fw);
		for(int x=1;x<5;x++)
		{
			bufw.write("abcd--"+x);
			bufw.newLine();//��ƽ̨ʹ�õĻ��з���
			bufw.flush();
		}
		
		
		//��ס:ֻҪ�õ� ���弼������Ҫˢ�¡�
//		bufw.flush();
		//��ʵ�رջ����������ڹرջ������е�������
		bufw.close();
		//
	}

}
