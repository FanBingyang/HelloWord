package BIXiangDongTV;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SplitFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		splitFile();
		merge();
	}
	
	public static void merge() throws IOException//合并文件
	{
		ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();
		
		for(int x=1;x<=3;x++)
		{
			al.add(new FileInputStream("D:\\Java\\绅士"+x+".part"));
		}
			final Iterator<FileInputStream> it = al.iterator();
			Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
				public boolean hasMoreElements()
				{
					return it.hasNext();
				}
				public FileInputStream nextElement()
				{
					return it.next();
				}
			};
			
			SequenceInputStream sis = new SequenceInputStream(en);
			
			FileOutputStream fos = new FileOutputStream("D:\\Java\\绅士123.mp3");
			
			byte[] buf = new byte[1024];
			int len = 0;
			while((len=sis.read(buf))!=-1)
			{
				fos.write(buf,0,len);
			}
			
			fos.close();
			sis.close();
		
		
	}
	
	public static void splitFile() throws IOException//切割文件
	{
		FileInputStream fis = new FileInputStream("D:\\Java\\绅士.mp3");
		FileOutputStream fos = null;
		byte[] buf = new byte[1024*2048];//将文件按2M大小切割
		int len = 0;
		int count = 1;
		while((len=fis.read(buf))!=-1)
		{
			fos = new FileOutputStream("D:\\Java\\绅士"+(count++)+".part");
			fos.write(buf,0,len);
			fos.close();
		}
		fis.close();
		
	}

}
