package BookExample11;

import java.io.FileOutputStream;
import java.io.IOException;

/*���ܼ�飺ʹ��FileOutputStream�������������ļ��У���������д���ļ�*/
public class FileOutputStreamUse {
	public FileOutputStreamUse(){
		String s="��־���¾��ɣ��Ƹ����ۣ��ٶ��ع����������������첻������н��������ǧԽ�׿����⡣";
		byte[] b=s.getBytes();    //ʹ��ƽ̨��Ĭ���ַ������� String ����Ϊ byte ���У���������洢��һ���µ� byte �����С�
		try{
		/*ʵ����һ���ļ�������Ķ������У�String���͵Ĳ�����FileOutputStreamUse.txt�����ı��ļ�����������ı��ļ���ָ����·�����Ѿ����ڣ��͸�����������ݣ�
		 * �������ָ����·���´���һ����Ϊ��FileOutputStreamUse.txt�����ı��ļ���Ҳ����ʹ�����ط���FileOutputStream(String name,boolean append)ָ��׷��
		 * ��ʽ��ʵ�����ı��ļ�ĩβ׷������*/
			FileOutputStream f=new FileOutputStream("D:/Java/Java����_1/Hello/src/BookExample11/FileOutputStreamUse.txt");
			f.write(b);
			f.flush();
			f.close();
		}catch(IOException e){
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileOutputStreamUse();
	}

}
