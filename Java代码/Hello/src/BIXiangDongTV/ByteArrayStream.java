package BIXiangDongTV;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ���ڲ����ֽ������������
 * 
 * ByteArrayInputStream���ڹ����ʱ����Ҫ�������ݣ���������Դ��һ���ֽ�����
 * ByteArrayOutputStream���ڹ����ʱ�򣬲���������Ŀ�ģ���Ϊ�ö������Ѿ��ڲ���װ�˿ɱ䳤�ȵ��ֽ�����
 * 							��������ݵ�Ŀ�ĵ�
 * 
 * ��Ϊ���������������������飬��û��ʹ��ϵͳ��Դ
 * ���Բ��ý���close�ر�
 * 
 * ������������ʱ��
 * Դ�豸��
 * 		����  System in�� Ӳ�� FileStream�� �ڴ� ArrayStream
 * Ŀ���豸��
 * 		����̨ System out��Ӳ�� FileStream�� �ڴ� ArrayStream
 * 
 * �����Ķ�д˼������������
 * 
 */
public class ByteArrayStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//����Դ
		ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEF".getBytes());
		
		//����Ŀ�ĵ�
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int by = 0;
		while((by=bis.read())!=-1)
		{
			bos.write(by);
		}
		System.out.println(bos.size());
		System.out.println(bos.toString());
		
		bos.writeTo(new FileOutputStream("D:\\Java\\ByteArrayStrream.txt"));
	}

}
