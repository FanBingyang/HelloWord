package BIXiangDongTV;


/*
 * ������ʽ������һ������ı��ʽ
 * 	����:����ר�Ų����ַ���
 * 	�ص㣺��һЩ�ض��ķ�������ʾһ�´�������������ͼ���д��
 * 
 * 	�ô������Լ򻯶��ַ����ĸ��Ӳ���
 *  �׶ˣ����Ŷ���Խ�࣬����Խ�����Ķ���Խ��
 * 
 * ����������ܣ�
 * 	1��ƥ�䣺String matches����,�ù���ƥ�������ַ�����ֻҪ��һ�������Ϲ���ģ�����false
 * 	
 * 	2���иString split();
 * 
 * 	3,�滻
 */
public class RegexDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		checkQQ();
//		splitDemo();
//		demo();
		
		String str = "asgf156454dfggs467";//���󣬽��ַ����е�5���������ϵ����������滻��#
		replaceAllDemo(str,"\\d{5,}","#");
		
		String str1 = "ashhhusfkkskdgupososdffffafgg";//�������滻��&
		replaceAllDemo(str1, "(.)\\1+", "&");
		
		String str2 = "ashhhusfkkkkskdguoooosdffffafgg";//��������ʻ���һ���ַ�   zzzzz->z
		replaceAllDemo(str2, "(.)\\1+","$1");//����Ԫ���Ż�ȡ�飬�ǻ�ȡ��Ŷ�Ӧ���ַ����е��ַ�
	}
	
	public static void replaceAllDemo(String str,String reg,String newStr) {
		str = str.replaceAll(reg, newStr);
		System.out.println(str);
	}
	public static void splitDemo() {
//		String str = "zhangsan  lisi,   wangwu";
//		String reg = " +";//���ղ�������ո��и�
		
//		String str = "zhangsan.lisi.jgk";
//		String reg = "\\.";//����ת���������������ʽ���. �и�
		
		String str = "agskkkdbuhyfhhagsdssbhdsggsdf";//���յ�������и�
		String reg = "(.)\\1+";//(.)�� . �ַ���װ��һ���飬\\1��ʾ��һλ��ǰ����Ϊ��ͬ
								//Ϊ�˿����ù���Ľ�������ã����Խ������װ��һ���飬��()��ɣ�
								//��ĳ��ֶ��б�ţ���1��ʼ����Ҫʹ�����е��飬����ͨ�� \n(n������ı��)�� ��ʽ����ȡ
		
		
		
		String [] arr = str.split(reg);
		for(String s : arr)
		{
			System.out.println(s);
		}
		
	}
	public static void demo() {
		String str = "da";
		
//		String reg = "[bcd]";//�жϵ�һ���ַ��Ƿ�Ϊb,c,d
		String reg = "[bcd][a-z]";//�жϵ�һ���ַ��Ƿ�Ϊb,c,d,�ڶ����ַ�Ϊa~z
		
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
			System.out.println("���Ϸ�");
		}
	}
	/*
	 * ����
	 * ��QQ�������У��
	 * Ҫ��5~15λ  0���ܿ�ͷ��ֻ��������
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
//					System.out.println("���ַǷ��ַ�");
//			}
//			else {
//				System.out.println("������0��ͷ");
//			}
//		}
//		else
//			System.out.println("���ȴ���");
//	}

}
