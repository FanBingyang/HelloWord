package BIXiangDongTV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*练习：
 * 将一个指定目录下的Java文件得绝对路径存储到一个文本文件中。
 * 建立一个Java文件列表文件。
 * 
 * 思路：
 * 1，对指定目录进行递归
 * 2，获取递归过程中所有的Java文件的路径
 * 3，将这些路径存储到集合中
 * 4，将集合中的数据写到一个文件夹中
 */
public class JavaFileList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Java\\Java代码_1\\Hello\\src\\BIXiangDongTV");
		List<File> list = new ArrayList<File>();
		
		fileToList(dir, list);
//		System.out.println(list.size());
		
		File file = new File("D:\\Java","BIXiangDongTV.java");
		writeToFile(list,file.toString());
		
		
	}
	
	public static void fileToList(File dir,List<File> list)
	{
		File[] files = dir.listFiles();
		for (File file : files) {
			if(file.isDirectory())
				fileToList(file, list);//函数递归
			else{
				if(file.getName().endsWith(".java"));
					list.add(file);
			}
		}
	}
	
	public static void writeToFile(List<File> list,String javaListFile) throws IOException
	{
		BufferedWriter bufw = null;
		try {
			bufw  = new BufferedWriter(new FileWriter(javaListFile));
			
			for (File f : list) {
				String path = f.getAbsolutePath();
				bufw.write(path);
				bufw.newLine();
				bufw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally
		{
			try {
				if(bufw!=null)
					bufw.close();
			} catch (Exception e2) {
				// TODO: handle exception
				throw e2;
			}
		}
	}

}
