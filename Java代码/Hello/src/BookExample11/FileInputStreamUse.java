package BookExample11;

import java.io.FileInputStream;
import java.io.IOException;

/*功能简介：使用FileInputStream类读取文件中的数据并输出到控制台，最后统计文件所占的字节数*/
public class FileInputStreamUse {
	public FileInputStreamUse(){
		try{
			/*通过构造方法实例化一个文件输入流对象，要访问的文本文件和源文件在同一个包中，所以需要使用绝对路径。
			 * 如"C:/Users/FBY/Desktop/FileInputStreamUse.txt",否则无法找到源文件*/
			FileInputStream f=new FileInputStream("D:/Java/Java代码_1/Hello/src/BookExample11/FileInputStreamUse.txt");
			int i;
			int b=f.read();      //从输入流中读取数据的下一个字节。
			for(i=0;b!=-1;i++){             //如果文件的数据读取完毕。返回值就为-1，表示读取文件结束
				System.out.println((char)b);
				b=f.read();
			}
			System.out.println();
			System.out.println("文件字节数为"+i);
			f.close();            //关闭文件流
		}catch(IOException e){
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileInputStreamUse();
	}

}
