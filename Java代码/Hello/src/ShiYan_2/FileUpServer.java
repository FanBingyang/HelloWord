package ShiYan_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class FileUpServer implements Runnable{
	private Socket socket;
	public FileUpServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		int count = 1;
		try {
			InputStream in = socket.getInputStream();
			File parentFile = new File("./");
			if(!parentFile.exists()) {  //���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ�
				parentFile.mkdir();  // �����˳���·����ָ����Ŀ¼��
			}
			File file = new File(parentFile,count+".jpg");
			while (file.exists()) {
				file = new File(parentFile,count++ +".jpg");
			}
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len = 0;
			while ((len=in.read(buf))!=-1) {
				fos.write(buf, 0, len);
			}
			OutputStream out = socket.getOutputStream();
			out.write("�ϴ��ɹ�".getBytes());
			fos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(12346);
		while (true) {
			Socket s = serverSocket.accept();
			Thread t = new Thread(new FileUpServer(s));
			t.start();
		}
	}
}
