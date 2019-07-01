package BIXiangDongTV;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * ������BUfferedReader�������з���readLine��ԭ���
 * �����Զ���һ�����а���һ�����ܺ�readLineһ�µķ�����
 * ��ģ��һ��BufferedReader
 */
public class MyBufferedReader extends Reader{
	private Reader r = null;
	MyBufferedReader(FileReader r)
	{
		this.r = r;
	}
	
	//����һ�ζ�ȡһ�����ݵķ���
	public String myReaderLine() throws IOException
	{
		//����һ��ԭBufferedReader��װ�����ַ����顣
		//����һ��StringBuilder��������Ϊ���ջ���Ҫ�����ݱ���ַ�����
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
		//Ϊ�˷�ֹ�������һ��û�лس������������ݶ�ʧ��
		//����������ж�һ�»��������Ƿ�Ϊ�գ������Ϊ�գ�
		//��˵�������������Ļ������ݣ���ʱ�����ݷ��ؼ��ɡ�
		if(sb.length()!=0)
			return sb.toString();
		return null;
	}
	/*
	 * ����Reader���еĳ��󷽷���
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
