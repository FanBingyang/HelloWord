package BIXiangDongTV;


/*
 * 正则表达式：符合一定规则的表达式
 * 	作用:用于专门操作字符串
 * 	特点：用一些特定的符号来表示一下代码操作，这样就简化书写。
 * 
 * 	好处：可以简化对字符串的复杂操作
 *  弊端：符号定义越多，正则越长，阅读性越差
 * 
 * 具体操作功能：
 * 	1，匹配：String matches方法,用规则匹配整个字符串，只要有一处不符合规则的，返回false
 * 	
 * 	2，切割：String split();
 * 
 * 	3,替换
 */
public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkQQ();
//		splitDemo();
//		demo();
		
		String str = "asgf156454dfggs467";//需求，将字符串中的5个数字以上的连续数字替换成#
		replaceAllDemo(str,"\\d{5,}","#");
		
		String str1 = "ashhhusfkkskdgupososdffffafgg";//将叠词替换成&
		replaceAllDemo(str1, "(.)\\1+", "&");
		
		String str2 = "ashhhusfkkkkskdguoooosdffffafgg";//将多个叠词换成一个字符   zzzzz->z
		replaceAllDemo(str2, "(.)\\1+","$1");//用美元符号获取组，是获取组号对应的字符串中的字符
	}
	
	public static void replaceAllDemo(String str,String reg,String newStr) {
		str = str.replaceAll(reg, newStr);
		System.out.println(str);
	}
	public static void splitDemo() {
//		String str = "zhangsan  lisi,   wangwu";
//		String reg = " +";//按照不定多个空格切割
		
//		String str = "zhangsan.lisi.jgk";
//		String reg = "\\.";//两次转义最后变成用正则表达式里的. 切割
		
		String str = "agskkkdbuhyfhhagsdssbhdsggsdf";//按照叠词完成切割
		String reg = "(.)\\1+";//(.)将 . 字符封装成一个组，\\1表示第一位和前面以为相同
								//为了可以让规则的结果被重用，可以将规则封装成一个组，用()完成，
								//组的出现都有编号，从1开始，想要使用现有的组，可以通过 \n(n就是组的编号)的 形式来获取
		
		
		
		String [] arr = str.split(reg);
		for(String s : arr)
		{
			System.out.println(s);
		}
		
	}
	public static void demo() {
		String str = "da";
		
//		String reg = "[bcd]";//判断第一个字符是否为b,c,d
		String reg = "[bcd][a-z]";//判断第一个字符是否为b,c,d,第二个字符为a~z
		
		boolean b=str.matches(reg);
		System.out.println(b);
	}
	public static void checkQQ() {
		String qq="123456789";
		
		String regex = "[1-9][0-9]{4,14}";
		
		boolean flag = qq.matches(regex);
		if(flag)
			System.out.println("qq:"+qq);
		else {
			System.out.println("不合法");
		}
	}
	/*
	 * 需求：
	 * 对QQ号码进行校验
	 * 要求：5~15位  0不能开头，只能是数字
	 * 
	 * 
	 */
//	public static void checkQQ_1() {
//		String qq="123456879";
//		
//		int len = qq.length();
//		
//		if(len>=5 && len<=15)
//		{
//			if(!qq.startsWith("0"))
//			{
//				char[] arr = qq.toCharArray();
//				boolean flag = false;
//				for(int i=0;i<arr.length;i++)
//				{
//					if((arr[i]>='0' && arr[i]<='9'))
//					{
//						flag = true;
//						break;
//					}
//				}
//				if(flag)
//					System.out.println("qq:"+qq);
//				else
//					System.out.println("出现非法字符");
//			}
//			else {
//				System.out.println("不可以0开头");
//			}
//		}
//		else
//			System.out.println("长度错误");
//	}

}
