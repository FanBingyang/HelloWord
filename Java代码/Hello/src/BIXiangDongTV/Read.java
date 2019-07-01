package BIXiangDongTV;

import java.io.IOException;
import java.io.PipedInputStream;

public class Read implements Runnable{

	private PipedInputStream in;
	Read(PipedInputStream in)
	{
		this.in = in;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			String s = new String(buf,0,len);
			System.out.println(s);
			in.close();
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("管道读取流失败");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
