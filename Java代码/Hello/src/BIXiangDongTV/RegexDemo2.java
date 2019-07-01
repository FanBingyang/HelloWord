package BIXiangDongTV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.synth.SynthScrollBarUI;

/*
 * 正则表达式的第四个功能
 * 4，获取：将字符串中符合规则的字串取出
 * 
 * 操作步骤：
 * 1，将正则表达式封装成对象
 * 2，让正则对象和要操作的字符串相关联
 * 3，关联之后，获取正则匹配引擎
 * 4，通关引擎对符合规则的字串进行操作，比如取出。
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
		
		String reg = "\\b[a-z]{3}\\b";//用于匹配出三个字母的单词。\b 代表的是单词边界
		//将规则封装成对象
		Pattern p =Pattern.compile(reg);
		
		//让正则对象和要作用的字符串相关联，获取匹配器对象
		Matcher m = p.matcher(str);
		
//		System.out.println(m.matches());//其实String类中的matches方法，用的就是Patt和Matcher对象来完成的。
										//只不过被String的方法封装后，用起来较为简单，但是功能却单一。
		
//		boolean b = m.find();//将规则作用到字符串上，并进行符合规则的字串查找
//		System.out.println(b);
//		System.out.println(m.group());//用于获取匹配后的结果
		
		//同一个匹配器中用的是同一个指针
		while(m.find())
		{
			System.out.println(m.group());
			System.out.println("该单词在字符串的位置是从"+m.start()+"到"+m.end());
												//start()起始索引位置。end()末尾偏移量。包含头不包含尾
		}
	}

}
