package BIXiangDongTV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = System.getProperties();//系统信息，就是虚拟机启动时加载的信息
		
		//System.out.println(prop);
		prop.list(new PrintStream("D:\\Java\\SystemInfo.txt"));//list()方法将属性列表输出到指定的输出流
	}

}
