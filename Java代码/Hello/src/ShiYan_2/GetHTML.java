package ShiYan_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * 通过URL获取网站的资源
 * @author FBY
 *
 */
public class GetHTML {

	public GetHTML() {
		try {
			URL url = new URL("http://www.zzuli.edu.cn");
			BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));//在封装流的时候表明编码格式，解决中文乱码问题
			
			String  string ;
			while ((string=bReader.readLine())!=null) {  //读取网络资源
				System.out.println(string);              //输出网络资源信息
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
