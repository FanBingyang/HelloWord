package BIXiangDongTV;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PippedStreamDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		in.connect(out);
		
		Read r = new Read(in);
		Write w = new Write(out);
		new Thread(r).start();
		new Thread(w).start();
		
		
	}

}
