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
	
	//һ�ζ�һ���ֽڣ��ӻ��������ֽ����飩��ȡ
	public int myRead() throws IOException
	{
		//ͨ��in�����ȡӲ�������ݣ����洢��buf�С�
		if(count==0)
		{
			count = in.read(buf);
			if(count<0)
				return -1;
			pos = 0;
			byte b = buf[pos];
			
			count--;
			pos++;
			return b&0xff;//0xff��255��16���Ʊ�ʾ��ʽ��
		}
		else if(count>0)
		{
			byte b = buf[pos];
			
			count--;
			pos++;
			return b&255;
			/*
			 * byte:-1   ----->����Ϊ int:-1
			 * 11111111			11111111 11111111 11111111 11111111    255
			 * 
			 * 11111111  --> ����Ϊһ��int���ͣ����ݻ���-1��ԭ������8��1��ǰ�油����11���µġ�
			 * ֻҪ��ǰ�油0���ȿ��Ա���ԭ�ֽ����ݲ��䣬�ֿ��Ա���-1�ĳ��֡�
			 * ��ô��0 �أ������루&������
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
