package BIXiangDongTV;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * 明白了BUfferedReader类中特有方法readLine的原理后，
 * 可以自定义一个类中包含一个功能和readLine一致的方法。
 * 来模拟一下BufferedReader
 */
public class MyBufferedReader extends Reader{
	private Reader r = null;
	MyBufferedReader(FileReader r)
	{
		this.r = r;
	}
	
	//可以一次读取一行数据的方法
	public String myReaderLine() throws IOException
	{
		//定义一个原BufferedReader封装的是字符数组。
		//定义一个StringBuilder容器，因为最终还是要将数据变成字符串。
		StringBuilder sb = new StringBuilder();
		int ch = 0;
		while((ch=r.read())!=-1)
		{
			if(ch=='\r')
				continue;
			if(ch=='\n')
				return sb.toString();
			else
				sb.append((char)ch);
		}
		//为了防止数据最后一行没有回车键而导致数据丢失，
		//解决方法是判断一下缓冲区内是否为空，如果不为空，
		//则说明缓冲区里面存的还有数据，此时将数据返回即可。
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}
	/*
	 * 覆盖Reader类中的抽象方法。
	 */
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		r.close();
	}
	@Override
	public int read(char[] cbuf,int off,int len)throws  IOException
	{
		return r.read(cbuf,off,len);
	}
	
	public void myClose() throws IOException
	{
		r.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
