package BIXiangDongTV;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		listRootsDemo();
//		listRoots();
//		list_2();
		
		File dir = new File("D:\\");
		File[] files = dir.listFiles();
		
		for (File file : files) {
			System.out.println(file.getName()+"::"+file.length());//����ָ��·���µ��ļ����ƺʹ�С���ļ��з��ش�СΪ0
		}
		
		
	}
	
	public static void list_2()
	{
		File f = new File("D:\\Java");
		String[] arr = f.list(new FilenameFilter(){  //�����ڲ���
			public boolean accept(File f,String name){
//				System.out.println("f:"+f+"...name:"+name);
			/*	if(name.endsWith(".txt"))
					return true;
				else
					return false;
			*/
				return name.endsWith(".txt");//�ļ�������
			}
		});
		System.out.println("len:"+arr.length);
		for (String name : arr) {
			System.out.println(name);
		}
		
	}
	
	public static void listRoots()
	{
		File f = new File("D:\\");
		
		String[] names = f.list();//�鿴ָ��Ŀ¼�µ��ļ����ļ������ƣ����������ļ���
								//����list������file��������װ��һ��Ŀ¼����Ŀ¼���������
		for(String name:names)
		{
			System.out.println(name);
		}
	}
	
	public static void listRootsDemo()
	{
		File[] files = File.listRoots();///������ǵ�ǰ������ʹ�õ��̷�
		
		for(File f:files)
		{
			System.out.println(f);
		}
	}

}
