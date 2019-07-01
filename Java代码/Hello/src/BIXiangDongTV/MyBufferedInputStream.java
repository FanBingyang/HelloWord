package BIXiangDongTV;
/*
 * 
 */
import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream {
	private InputStream in;
	private byte[] buf = new byte[1024*4];
	private int pos = 0,count = 0;
	
	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}
	
	//一次读一个字节，从缓冲区（字节数组）获取
	public int myRead() throws IOException
	{
		//通过in对象读取硬盘上数据，并存储到buf中。
		if(count==0)
		{
			count = in.read(buf);
			if(count<0)
				return -1;
			pos = 0;
			byte b = buf[pos];
			
			count--;
			pos++;
			return b&0xff;//0xff是255的16进制表示形式。
		}
		else if(count>0)
		{
			byte b = buf[pos];
			
			count--;
			pos++;
			return b&255;
			/*
			 * byte:-1   ----->提升为 int:-1
			 * 11111111			11111111 11111111 11111111 11111111    255
			 * 
			 * 11111111  --> 提升为一个int类型，数据还是-1，原因是在8个1的前面补的是11导致的。
			 * 只要在前面补0，既可以保留原字节数据不变，又可以避免-1的出现。
			 * 怎么补0 呢？进行与（&）操作
			 *   11111111 11111111 11111111 11111111
			 * & 00000000 00000000 00000000 11111111  
			 * --------------------------------------
			 *   00000000 00000000 00000000 11111111
			 * 
			 */
		}
		return -1;
	}
	
	public void myClose() throws IOException
	{
		in.close();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
