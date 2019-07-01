package BIXiangDongTV;

import java.io.File;

/*
 * 删除一个带内容的目录。
 * 
 * 删除原理：
 * 在window中，删除目录是从里面往外面删除的。
 * 既然是从里往外删除，就需要用到递归了。
 * 
 * ***注意：通过Java删除的文件不会留在回收站！！！
 * 
 */
public class RemoveDir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Java\\bilaoshi");
		removeDir(dir);
	}
	
	public static void removeDir(File dir)
	{
		File[] files = dir.listFiles();
		
		for (int x = 0; x < files.length; x++) {
			if(files[x].isDirectory())
				removeDir(files[x]);
			else
				System.out.println(files[x].toString()+":"+files[x].delete());
		}
		System.out.println(dir+"::"+dir.delete());
	}

}
