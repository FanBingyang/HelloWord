package BIXiangDongTV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *��ϰ
 *���ڼ�¼Ӧ�ó������д�����
 *���ʹ�ô����ѵ�����ô����ע����ʾ��
 *--------------------------------------
 *�������뵽���ǣ���������
 *���Ǹü����������ڳ����У����ų�������ж����ڴ��д��ڣ�������������
 *�������Ÿ�Ӧ�ó�����˳����ü�����Ҳ���ڴ�����ʧ�ˡ�
 *��һ������������ʱ�ֿ�ʼ��0���¼���
 *
 *����ʹ�������ü�������ֵҲ���ڡ�
 *�´γ�������ʱ���ȼ��ظü�������ֵ���ټ�1�����´洢������
 *����Ҫ����һ�������ļ������ڼ�¼�������ʹ�ô�����
 *�������ļ�ʹ�ü�ֵ�Ե���ʽ��
 *���������Ķ����ݣ����������ݡ�
 *
 *��ֵ��������map���ϡ�
 *���������ļ���ʽ�洢��ʹ��io������
 *��ômap+io--->properties.
 *�����ļ�����ʵ��Ӧ�ó������ݵĹ���
 *
 */
public class RunCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		File file = new File("D:\\Java\\RunCount.ini");//ini�������ļ���ʽ
		if(!file.exists())
			file.createNewFile();
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		int count = 0;
		String value = prop.getProperty("time");
		if(value!=null)
		{
			count = Integer.parseInt(value);
			if(count>=5)
			{
				System.out.println("���ã�ʹ�ô����Ե�����Ǯ��");
				return;
				
			}
		}
		count++;
		
		prop.setProperty("time", count+"");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		prop.store(fos, "");
		
		fos.close();
		fis.close();
		
		
		
			
		
	}

}
