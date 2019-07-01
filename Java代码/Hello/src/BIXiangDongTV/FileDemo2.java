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
			System.out.println(file.getName()+"::"+file.length());//返回指定路径下的文件名称和大小，文件夹返回大小为0
		}
		
		
	}
	
	public static void list_2()
	{
		File f = new File("D:\\Java");
		String[] arr = f.list(new FilenameFilter(){  //匿名内部类
			public boolean accept(File f,String name){
//				System.out.println("f:"+f+"...name:"+name);
			/*	if(name.endsWith(".txt"))
					return true;
				else
					return false;
			*/
				return name.endsWith(".txt");//文件名过滤
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
		
		String[] names = f.list();//查看指定目录下的文件和文件夹名称，包括隐藏文件。
								//调用list方法的file对象必须封装了一个目录，该目录还必须存在
		for(String name:names)
		{
			System.out.println(name);
		}
	}
	
	public static void listRootsDemo()
	{
		File[] files = File.listRoots();///保存的是当前机器能使用的盘符
		
		for(File f:files)
		{
			System.out.println(f);
		}
	}

}
