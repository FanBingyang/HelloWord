package BIXiangDongTV;

import java.io.IOException;
import java.io.PipedOutputStream;

public class Write implements Runnable{
	private PipedOutputStream out;
	public Write(PipedOutputStream out) {
		// TODO Auto-generated constructor stub
		this.out = out;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			out.write("guandao lai le ".getBytes());
			out.close();
			
			
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("管道输出流失败");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
