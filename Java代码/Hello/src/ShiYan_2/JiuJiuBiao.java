package ShiYan_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class JiuJiuBiao {

	public static void main(String[] args) {
		try {
			FileWriter fr = new FileWriter("./99.txt");
//			注释部分为用字节流实现
//			FileOutputStream fos = new FileOutputStream("./99(2).txt");
//			String s;
			fr.write("九九乘法表\r\n");
			for(int i=1;i<=9;i++) {
				for(int j=1;j<=i;j++) {
//					s = j+"*"+i+"="+i*j+" ";
//					fos.write(s.getBytes());
//					fos.flush();
					fr.write(j+"*"+i+"="+i*j+" ");
				}
//				fos.write("\r\n".getBytes());
				fr.write("\r\n");
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
