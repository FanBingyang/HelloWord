package BIXiangDongTV;
/*
 �����ÿɱ������
 ��ʹ��ʱע�⣺�ɱ����һ��Ҫ�����ڲ����б������档
  
 */
public class ParamMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		��Ȼ�ٶ����˶������������ÿһ�ζ�Ҫ����һ��������Ϊʵ�ʲ���
//		int[] arr={3,4};
//		show(arr);
		
		
		/*�ɱ������
		 * ��ʵ������һ����������ü�д��ʽ������ÿһ�ζ��ֶ��ý���
		 * �������ֻҪ��Ҫ������Ԫ����Ϊ�������ݼ��ɡ�
		 * ��ʽ����Щ������װ�������顣
		 * 
		 * 
		 * 
		 */
		show("haha",2,3,4);
		
		
		
	}
	public static void show(String str,int... arr)//����ɱ��������
	{
		System.out.println(str);
		System.out.println(arr.length);
	}
	
/*	public static void show(int[] arr)
	{
		
	}
*/	
/*	
	public static void show(int a,int b)
	{
		System.out.println(a+","+b);
	}
*/
}
