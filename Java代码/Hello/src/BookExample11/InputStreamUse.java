package BookExample11;
/*���ܼ�飺ͨ�������������ݲ���Enter�����󣬽�������������������̨*/
import java.io.IOException;
import java.io.InputStream;

public class InputStreamUse {
	public InputStreamUse(InputStream in){     //���췽��������������ݲ����������
		try{
			while(true){
				int i=in.read();            //read()���������ж�ȡ���ݵ���һ���ֽڡ�
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
