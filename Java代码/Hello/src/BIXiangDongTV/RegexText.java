package BIXiangDongTV;

import java.util.TreeSet;

public class RegexText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test_1();
//		test_2();
		test_3();
	}
	/*
	 * 需求：
	 * 将下列字符串装换成：我要学编程
	 * 
	 * 需要用到正则表达式中的那些功能呢？
	 * 思路方式：
	 * 1，如果只想要知道该字符串是对是错，用匹配。
	 * 2，想要将已有的字符串编程另一个字符串，用替换。
	 * 3，想要按照自己的方式将字符串编程多个字符串，用切割，获取规则以外的字符串
	 * 4，想要拿到符合需求的字符串字串，获取，获取符合规则的字串
	 */
	public static void test_1() {
		/*
		 * 将已有字符串变成另一个字符串，使用替换功能
		 * 1，可以先将  。 去掉
		 * 2，再将多个重复的内容变成单个字符串
		 */
		String str = "我我。。。我我。。。我要。。。要要。。。要要。。。学学学。。。学学。。。编编编。。。编程。。。程。。。程程。。。程。。。程程";
		
		str = str.replaceAll("\\。+", "");
		System.out.println(str);
		
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	public static void test_2() {
		/*
		 * 192.68.1.254  102.49.23.13  10.10.10.10  2.2.2.2  8.109.90.30
		 * 将IP地址进行地址段顺序排序
		 * 
		 * 还按照字符串自然数寻，只要让他们每一段都是3位即可
		 * 1，按照每一段需要的最多的0进行补齐，那么每一段就会至少保证是3位
		 * 2，将每一段只保留3位，这样所有的IP地址都是每一段3位
		 * 
		 */
		
		String ip = "192.68.1.254  102.49.23.13  10.10.10.10  2.2.2.2  8.109.90.30";
		System.out.println(ip);
		
		ip = ip.replaceAll("(\\d+)","00$1");
		System.out.println(ip);
		
		ip = ip.replaceAll("0*(\\d{3})","$1");
		System.out.println(ip);
		
		String[] arr = ip.split(" ");
		
		TreeSet<String> ts = new TreeSet<String>();
		
		for(String s : arr)
		{
			ts.add(s);
		}
		
		for(String s : ts)
		{
			System.out.println(s.replaceAll("0*(\\d+)","$1"));
		}
		
	}
	
	
	public static void test_3() {
		/*
		 * 需求：对邮件地址进行校验
		 */
		String mail = "abc12@sina.com.cn";
		
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";//较为精确的匹配
		reg = "\\w+@\\w+(\\.\\w+)+";//相对不太精确的匹配
		
		System.out.println(mail.matches(reg));
	}
}
