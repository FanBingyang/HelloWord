package BIXiangDongTV;

import java.io.FileReader;

/*
 * �ڶ��ֶ�ȡ��ʽ��ͨ���ַ�������ж�ȡ*/
public class FileReaderDemo2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr = new FileReader("D:\\Java\\FielWriterDemo.txt");
		 
		//����һ���ַ����飬���ڴ���������ַ�
		//��read(char[])���ص��Ƕ������ַ�����
		char[] buf = new char[1024];  //�����Сһ�㶨��Ϊ1024����������
	/*	 int num = fr.read(buf);
		 
		 System.out.println("num="+num+"..."+new String(buf));
	*/
		
		int num = 0;
		while((num=fr.read(buf))!=-1)
		{
			System.out.println(new String(buf,0,num));//���������ʹ�ӡ��������
		/*
		 * public String(char[] value,
              int offset,
              int count)����һ���µ� String��������ȡ���ַ��������һ����������ַ���
              offset �������������һ���ַ���������count ����ָ��������ĳ��ȡ�
 			   ��������������ѱ����ƣ��������ַ�������޸Ĳ���Ӱ���´������ַ�����
		������
		value - ��Ϊ�ַ�Դ�����顣
		offset - ��ʼƫ������
		count - ���ȡ�
		 */
		}
		 fr.close();
	}

}
