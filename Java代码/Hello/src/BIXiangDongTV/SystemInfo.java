package BIXiangDongTV;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class SystemInfo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = System.getProperties();//ϵͳ��Ϣ���������������ʱ���ص���Ϣ
		
		//System.out.println(prop);
		prop.list(new PrintStream("D:\\Java\\SystemInfo.txt"));//list()�����������б������ָ���������
	}

}
