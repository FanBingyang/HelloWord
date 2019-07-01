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
	 * ����
	 * �������ַ���װ���ɣ���Ҫѧ���
	 * 
	 * ��Ҫ�õ�������ʽ�е���Щ�����أ�
	 * ˼·��ʽ��
	 * 1�����ֻ��Ҫ֪�����ַ����Ƕ��Ǵ���ƥ�䡣
	 * 2����Ҫ�����е��ַ��������һ���ַ��������滻��
	 * 3����Ҫ�����Լ��ķ�ʽ���ַ�����̶���ַ��������и��ȡ����������ַ���
	 * 4����Ҫ�õ�����������ַ����ִ�����ȡ����ȡ���Ϲ�����ִ�
	 */
	public static void test_1() {
		/*
		 * �������ַ��������һ���ַ�����ʹ���滻����
		 * 1�������Ƚ�  �� ȥ��
		 * 2���ٽ�����ظ������ݱ�ɵ����ַ���
		 */
		String str = "���ҡ��������ҡ�������Ҫ������ҪҪ������ҪҪ������ѧѧѧ������ѧѧ���������ࡣ������̡������̡������̡̳������̡������̳�";
		
		str = str.replaceAll("\\��+", "");
		System.out.println(str);
		
		str = str.replaceAll("(.)\\1+", "$1");
		System.out.println(str);
	}
	
	public static void test_2() {
		/*
		 * 192.68.1.254  102.49.23.13  10.10.10.10  2.2.2.2  8.109.90.30
		 * ��IP��ַ���е�ַ��˳������
		 * 
		 * �������ַ�����Ȼ��Ѱ��ֻҪ������ÿһ�ζ���3λ����
		 * 1������ÿһ����Ҫ������0���в��룬��ôÿһ�ξͻ����ٱ�֤��3λ
		 * 2����ÿһ��ֻ����3λ���������е�IP��ַ����ÿһ��3λ
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
		 * ���󣺶��ʼ���ַ����У��
		 */
		String mail = "abc12@sina.com.cn";
		
		String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";//��Ϊ��ȷ��ƥ��
		reg = "\\w+@\\w+(\\.\\w+)+";//��Բ�̫��ȷ��ƥ��
		
		System.out.println(mail.matches(reg));
	}
}
