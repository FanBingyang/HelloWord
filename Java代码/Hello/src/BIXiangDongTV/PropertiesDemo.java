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
 * Properties是hashtable的子类。
 * 也就是说他是具备map集合的特点，而且它里面村的是键值对都是字符串。
 * 
 * 是集合中和IO技术相结合的集合容器。
 * 
 * 该对象的特点：可以用于键值对形式的配置文件。
 * 那么在加载数据时需要数据有固定格式，通常是 键=值
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
		
		//将流中的数据加载进集合，
		prop.load(fis);
		prop.setProperty("wangwu", "39");
		
		FileOutputStream fos = new FileOutputStream("D:\\Java\\Properties.txt");
		prop.store(fos, "haha");
		
//		System.out.println(prop);
		
		prop.list(System.out);
		
		fos.close();
		fis.close();
		
		
	}
	
	//演示，如何将流中的数据转存到集合中
	//想要将Properties.txt文件中的键值数据存储到集合中进行操作
	/*
	 * 1，用一个流和Properties.txt文件进行关联。
	 * 2，读取一行数据，将该数据用"="进行切割。
	 * 3，等号左边作为键，右边作为值，存入到Properties集合中即可
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
	
	//设置和获取元素
	public static void setaAndGet()
	{
		Properties prop = new Properties();
		prop.setProperty("zhangsan","30");
		prop.setProperty("lisi","50");
		
//		System.out.println(prop);
		
//		String value = prop.getProperty("lisi");//通过键获取值
//		System.out.println(value);
		
		prop.setProperty("lisi", 89+"");  //通过键修改值
		Set<String> names = prop.stringPropertyNames();//将键名存入到一个集合中
		for (String s : names) {
			System.out.println(s+":"+prop.getProperty(s));
		}
		
	}

}
