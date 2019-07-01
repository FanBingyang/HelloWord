package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
 * Properties��hashtable�����ࡣ
 * Ҳ����˵���Ǿ߱�map���ϵ��ص㣬�������������Ǽ�ֵ�Զ����ַ�����
 * 
 * �Ǽ����к�IO�������ϵļ���������
 * 
 * �ö�����ص㣺�������ڼ�ֵ����ʽ�������ļ���
 * ��ô�ڼ�������ʱ��Ҫ�����й̶���ʽ��ͨ���� ��=ֵ
 */
public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		setaAndGet();
//		method_1();
		loadDemo();
	}
	
	
	public static void loadDemo() throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Java\\Properties.txt");
		
		Properties prop = new Properties();
		
		//�����е����ݼ��ؽ����ϣ�
		prop.load(fis);
		prop.setProperty("wangwu", "39");
		
		FileOutputStream fos = new FileOutputStream("D:\\Java\\Properties.txt");
		prop.store(fos, "haha");
		
//		System.out.println(prop);
		
		prop.list(System.out);
		
		fos.close();
		fis.close();
		
		
	}
	
	//��ʾ����ν����е�����ת�浽������
	//��Ҫ��Properties.txt�ļ��еļ�ֵ���ݴ洢�������н��в���
	/*
	 * 1����һ������Properties.txt�ļ����й�����
	 * 2����ȡһ�����ݣ�����������"="�����и
	 * 3���Ⱥ������Ϊ�����ұ���Ϊֵ�����뵽Properties�����м���
	 */
	public static void method_1() throws IOException
	{
		BufferedReader bufr = new BufferedReader(new FileReader("D:\\Java\\Properties.txt"));
		
		String line = null;
		Properties prop = new Properties();
		while((line=bufr.readLine())!=null)
		{
			String[] arr = line.split("=");
//			System.out.println(arr[0]+"..."+arr[1]);
			prop.setProperty(arr[0], arr[1]);
		}
		
		bufr.close();
		System.out.println(prop);
	}
	
	//���úͻ�ȡԪ��
	public static void setaAndGet()
	{
		Properties prop = new Properties();
		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","50");
		
//		System.out.println(prop);
		
//		String value = prop.getProperty("lisi");//ͨ������ȡֵ
//		System.out.println(value);
		
		prop.setProperty("lisi", 89+"");  //ͨ�����޸�ֵ
		Set<String> names = prop.stringPropertyNames();//���������뵽һ��������
		for (String s : names) {
			System.out.println(s+":"+prop.getProperty(s));
		}
		
	}

}
