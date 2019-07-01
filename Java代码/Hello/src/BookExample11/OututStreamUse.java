package BookExample11;

import java.io.IOException;
import java.io.OutputStream;

/*功能简介：使用OututStream类在控制台输出数据*/
public class OututStreamUse {
	public OututStreamUse(OutputStream out){
		String s="慈母手中线，游子身上衣。临行密密缝，意恐迟迟归。谁言寸草心，报的三春晖。";
		byte[] b=s.getBytes();
		try{
			out.write(b);       //将字节数组b写到输出到输出流
			out.flush();        //把缓存中的所有内容刷新
			out.close();        //关闭输出流
		}catch(IOException e){
			System.err.println(e);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new OututStreamUse(System.out);
	}

}
