package BIXiangDongTV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*��ϰ��
 * ��һ��ָ��Ŀ¼�µ�Java�ļ��þ���·���洢��һ���ı��ļ��С�
 * ����һ��Java�ļ��б��ļ���
 * 
 * ˼·��
 * 1����ָ��Ŀ¼���еݹ�
 * 2����ȡ�ݹ���������е�Java�ļ���·��
 * 3������Щ·���洢��������
 * 4���������е�����д��һ���ļ�����
 */
public class JavaFileList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File("D:\\Java\\Java����_1\\Hello\\src\\BIXiangDongTV");
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
				fileToList(file, list);//�����ݹ�
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
