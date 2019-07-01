package BookExample11;

import java.io.FileOutputStream;
import java.io.IOException;

/*功能简介：使用FileOutputStream类把数据输出到文件中，即把数据写入文件*/
public class FileOutputStreamUse {
	public FileOutputStreamUse(){
		String s="有志者事竟成，破釜沉舟，百二秦关终属楚；苦心人天不负，卧薪尝胆，三千越甲可吞吴。";
		byte[] b=s.getBytes();    //使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
		try{
		/*实例化一个文件输出流的对象。其中，String类型的参数“FileOutputStreamUse.txt”是文本文件名，如果该文本文件在指定的路径下已经存在，就覆盖里面的内容，
		 * 否则就在指定的路径下创建一个名为“FileOutputStreamUse.txt”的文本文件，也可以使用重载方法FileOutputStream(String name,boolean append)指定追加
		 * 方式，实现在文本文件末尾追加内容*/
			FileOutputStream f=new FileOutputStream("D:/Java/Java代码_1/Hello/src/BookExample11/FileOutputStreamUse.txt");
			f.write(b);
			f.flush();
			f.close();
		}catch(IOException e){
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileOutputStreamUse();
	}

}
