package ShiYan_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
	public static void main(String[] args) {
		try {
			FileInputStream fr = new FileInputStream("./copy.txt");
			FileOutputStream fw = new FileOutputStream("./copy_1.txt");
			int i = fr.read();
			while(i!=-1) {
				fw.write(i);
				i = fr.read();
			}
			
			fr.close();
			fw.close();
			System.out.println("复制文件成功");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("复制文件失败");
			e.printStackTrace();
		}
	}
}
