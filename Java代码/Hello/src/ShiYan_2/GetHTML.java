package ShiYan_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * ͨ��URL��ȡ��վ����Դ
 * @author FBY
 *
 */
public class GetHTML {

	public GetHTML() {
		try {
			URL url = new URL("http://www.zzuli.edu.cn");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));//�ڷ�װ����ʱ����������ʽ�����������������
			
			String  string ;
			while ((string=bReader.readLine())!=null) {  //��ȡ������Դ
				System.out.println(string);              //���������Դ��Ϣ
			}
			bReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			new GetHTML();
	}

}
