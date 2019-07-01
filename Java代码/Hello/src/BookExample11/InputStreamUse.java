package BookExample11;
/*功能简介：通过键盘输入数据并按Enter按键后，将输入的数据输出到控制台*/
import java.io.IOException;
import java.io.InputStream;

public class InputStreamUse {
	public InputStreamUse(InputStream in){     //构造方法接受输入的数据并将数据输出
		try{
			while(true){
				int i=in.read();            //read()从输入流中读取数据的下一个字节。
				char c=(char)i;
				System.out.print(c);
			}
		}catch(IOException e){
			System.out.print(e);
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InputStreamUse(System.in);
	}
}
