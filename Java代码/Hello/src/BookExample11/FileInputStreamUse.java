package BookExample11;

import java.io.FileInputStream;
import java.io.IOException;

/*���ܼ�飺ʹ��FileInputStream���ȡ�ļ��е����ݲ����������̨�����ͳ���ļ���ռ���ֽ���*/
public class FileInputStreamUse {
	public FileInputStreamUse(){
		try{
			/*ͨ�����췽��ʵ����һ���ļ�����������Ҫ���ʵ��ı��ļ���Դ�ļ���ͬһ�����У�������Ҫʹ�þ���·����
			 * ��"C:/Users/FBY/Desktop/FileInputStreamUse.txt",�����޷��ҵ�Դ�ļ�*/
			FileInputStream f=new FileInputStream("D:/Java/Java����_1/Hello/src/BookExample11/FileInputStreamUse.txt");
			int i;
			int b=f.read();      //���������ж�ȡ���ݵ���һ���ֽڡ�
			for(i=0;b!=-1;i++){             //����ļ������ݶ�ȡ��ϡ�����ֵ��Ϊ-1����ʾ��ȡ�ļ�����
				System.out.println((char)b);
				b=f.read();
			}
			System.out.println();
			System.out.println("�ļ��ֽ���Ϊ"+i);
			f.close();            //�ر��ļ���
		}catch(IOException e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileInputStreamUse();
	}

}
