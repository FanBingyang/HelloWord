package BIXiangDongTV;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 用于操作字节数组得流对象
 * 
 * ByteArrayInputStream：在构造得时候，需要接受数据，而且数据源是一个字节数组
 * ByteArrayOutputStream：在构造的时候，不定义数据目的，因为该对象中已经内部封装了可变长度的字节数组
 * 							这就是数据的目的地
 * 
 * 因为这两个流对象都造作的数组，并没有使用系统资源
 * 所以不用进行close关闭
 * 
 * 在流操作讲解时：
 * 源设备：
 * 		键盘  System in， 硬盘 FileStream， 内存 ArrayStream
 * 目的设备：
 * 		控制台 System out，硬盘 FileStream， 内存 ArrayStream
 * 
 * 用流的读写思想来操作数据
 * 
 */
public class ByteArrayStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//数据源
		ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEF".getBytes());
		
		//数据目的地
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		int by = 0;
		while((by=bis.read())!=-1)
		{
			bos.write(by);
		}
		System.out.println(bos.size());
		System.out.println(bos.toString());
		
		bos.writeTo(new FileOutputStream("D:\\Java\\ByteArrayStrream.txt"));
	}

}
