package BIXiangDongTV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * ��ҳ����(֩��)
 */
public class RegexTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getMails();
	}
	
	/*
	 * ��ҳ����
	 * ��һ����ҳ�ϻ�ȡ����ҳ����ʾ�������ַ
	 */
	public static void getMails_2() throws Exception {
		URL url = new URL("http://");
		
		URLConnection conn = url.openConnection();
		
		BufferedReader bufr = new BufferedReader(new FileReader(".txt"));
		
		String line = null;
		
		String reg = "\\w+@\\w+(\\.\\w+)+";
		
		Pattern p =Pattern.compile(reg);
		
		while((line=bufr.readLine())!=null)
		{
			Matcher m = p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
			}
		}
		
		
	}
	/*
	 * ��ȡָ���ĵ��е��ʼ���ַ
	 * ʹ�û�ȡ���ܡ�Pattern��Matcher
	 */
	public static void getMails() throws Exception {
		BufferedReader bufr = new BufferedReader(new FileReader(".txt"));
		
		String line = null;
		
		String reg = "\\w+@\\w+(\\.\\w+)+";
		
		Pattern p =Pattern.compile(reg);
		
		while((line=bufr.readLine())!=null)
		{
			Matcher m = p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
			}
		}
	}

}
