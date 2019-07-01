package BIXiangDongTV;
/*
 方法得可变参数：
 在使用时注意：可变参数一定要定义在参数列表的最后面。
  
 */
public class ParamMethodDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		虽然少定义了多个方法，但事每一次都要定义一个数组作为实际参数
//		int[] arr={3,4};
//		show(arr);
		
		
		/*可变参数：
		 * 其实就是上一种数组参数得简写形式，不用每一次都手动得建立
		 * 数组对象，只要将要操作的元素作为参数传递即可。
		 * 隐式将这些参数封装成了数组。
		 * 
		 * 
		 * 
		 */
		show("haha",2,3,4);
		
		
		
	}
	public static void show(String str,int... arr)//构造可变参数函数
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
