package BIXiangDongTV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthScrollBarUI;

/*
 * ������ʽ�ĵ��ĸ�����
 * 4����ȡ�����ַ����з��Ϲ�����ִ�ȡ��
 * 
 * �������裺
 * 1����������ʽ��װ�ɶ���
 * 2������������Ҫ�������ַ��������
 * 3������֮�󣬻�ȡ����ƥ������
 * 4��ͨ������Է��Ϲ�����ִ����в���������ȡ����
 * 
 * 
 */
public class RegexDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getDemo();
	}
	
	public static void getDemo() {
		String str = "ming tian jiu yao fanhg jia le";
		
//		str = "0123456";
//		String reg = "[1-9]\\d{4,14}";
		
		String reg = "\\b[a-z]{3}\\b";//����ƥ���������ĸ�ĵ��ʡ�\b ������ǵ��ʱ߽�
		//�������װ�ɶ���
		Pattern p =Pattern.compile(reg);
		
		//����������Ҫ���õ��ַ������������ȡƥ��������
		Matcher m = p.matcher(str);
		
//		System.out.println(m.matches());//��ʵString���е�matches�������õľ���Patt��Matcher��������ɵġ�
										//ֻ������String�ķ�����װ����������Ϊ�򵥣����ǹ���ȴ��һ��
		
//		boolean b = m.find();//���������õ��ַ����ϣ������з��Ϲ�����ִ�����
//		System.out.println(b);
//		System.out.println(m.group());//���ڻ�ȡƥ���Ľ��
		
		//ͬһ��ƥ�������õ���ͬһ��ָ��
		while(m.find())
		{
			System.out.println(m.group());
			System.out.println("�õ������ַ�����λ���Ǵ�"+m.start()+"��"+m.end());
												//start()��ʼ����λ�á�end()ĩβƫ����������ͷ������β
		}
	}

}
