package BIXiangDongTV;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 *练习
 *用于记录应用程序运行次数。
 *如果使用次数已到，那么给出注册提示。
 *--------------------------------------
 *很容易想到的是：计数器。
 *可是该计数器定义在程序中，随着程序的运行而在内存中存在，并进行自增。
 *可是随着该应用程序的退出，该计数器也在内存中消失了。
 *下一次再启动程序时又开始从0重新计数
 *
 *程序即使结束，该计数器的值也存在。
 *下次程序启动时会先加载该计数器的值并再加1后重新存储起来。
 *所以要建立一个配置文件，用于记录该软件的使用次数。
 *该配置文件使用键值对的形式，
 *这样便于阅读数据，并操作数据。
 *
 *键值对数据是map集合。
 *数据是以文件形式存储，使用io技术。
 *那么map+io--->properties.
 *配置文件可以实现应用程序数据的共享。
 *
 */
public class RunCount {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		File file = new File("D:\\Java\\RunCount.ini");//ini是配置文件格式
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
				System.out.println("您好，使用次数以到，拿钱！");
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
