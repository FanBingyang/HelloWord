package BIXiangDongTV;

import java.io.File;

/*
 * ɾ��һ�������ݵ�Ŀ¼��
 * 
 * ɾ��ԭ��
 * ��window�У�ɾ��Ŀ¼�Ǵ�����������ɾ���ġ�
 * ��Ȼ�Ǵ�������ɾ��������Ҫ�õ��ݹ��ˡ�
 * 
 * ***ע�⣺ͨ��Javaɾ�����ļ��������ڻ���վ������
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
