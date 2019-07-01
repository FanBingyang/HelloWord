package ShiYan_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IfFileServer {
	private Socket socket;
	public IfFileServer(Socket socket) {
		this.socket = socket;
		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte[] buf =new byte[1024];
			int num = in.read(buf);
			String fileName =new String(buf, 0, num);
			File file = new File(fileName);
			if (file.exists()) {//如果该文件存在
				FileInputStream fis = new FileInputStream(file);
				byte[] buff = new byte[1024];
				int len = 0;
				while ((len=fis.read(buff))!=-1) {
					out.write(buff, 0, len);
				}
				//关闭socket流，但是不会断开连接
				socket.shutdownOutput();
			}else {//如果文件不存在
				out.write("该文件不存在".getBytes());
			}
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(12345);
		Socket s = serverSocket.accept();
		new IfFileServer(s);

	}

}
