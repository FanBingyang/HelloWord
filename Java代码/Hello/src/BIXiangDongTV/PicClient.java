package BIXiangDongTV;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 需求：上传图片
 * @author FBY
 */

/*
 * 客户端
 * 1，服务端点
 * 2，读取客户端以有的图片数据
 * 3，通过socket输出流将数据发给服务端
 * 4，读取服务端反馈信息
 * 5，关闭
 */
public class PicClient {

	public static void main(String[] args) throws Exception {
		if(args.length!=1){
			System.out.println("请选择一个jpg格式的图片");
			return;
		}
		
		File file = new File(args[0]);
		if(!(file.exists() && file.isFile())){
			System.out.println("该文件有问题，要么不存在，，要么不是文件");
			return;
		}
		
		if((!file.getName().endsWith(".jpg")) || (!file.getName().endsWith(".PNG"))){
			System.out.println("图片格式错误，请重新选择");
			return;
		}
		
		if(file.length()>1024*1024*5){//文件不能超过5M
			System.out.println("文件过大");
			return;
		}
		
		
		
		Socket s = new Socket(InetAddress.getLocalHost().getHostAddress(),10005);

		FileInputStream fis = new FileInputStream("D:\\Java\\药库一.png");
		
		OutputStream out = s.getOutputStream();
		
		byte[] buf = new byte[1024];
		
		int len = 0;
		
		while ((len=fis.read(buf))!=-1) {
			out.write(buf, 0, len);
		}
		
		//告诉服务端数据已经写完
		s.shutdownOutput();
		
		InputStream in = s.getInputStream();
		
		byte[] bufIn = new byte[1024];
		
		int num = in.read(bufIn);
		System.out.println(new String(bufIn,0,num));
		
		fis.close();
		s.close();
		
	}

}
