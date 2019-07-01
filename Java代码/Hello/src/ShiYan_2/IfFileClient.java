package ShiYan_2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class IfFileClient {
	
	public static void main(String[] args) throws Exception{
		String fileName = new String("./нд╪Ч.txt");
		Socket socket = new Socket("127.0.0.1", 12345);
		OutputStream out = socket.getOutputStream();
		InputStream in = socket.getInputStream();
		out.write(fileName.getBytes());
		byte[] buf = new byte[1024];
		int len = 0;
		while ((len = in.read(buf))!=-1) {
			String string = new String(buf, 0, len);
			System.out.println(string);
		}
		socket.close();

	}

}
