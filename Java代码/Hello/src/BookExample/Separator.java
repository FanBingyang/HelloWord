package BookExample;
/*
         功能简介：本程序演示分隔符的使用。首先声明一个数组，然后通过for语句把数组的值取出并相加，最后输出计算结果。
 */
public class Separator {
	public static void main(String args[]){
		int i,sum=0;      //声明整型变量i和sum并初始化
		int a[]={1,2,3,4,5};     //声明整型数组并初始化
		for(i=0;i<a.length;i++)  //循环控制语句实现数组遍历
		{
			sum+=a[i];           //遍历数组并计算结果
		}     //for语句结束
		System.out.println("累加之和等于"+sum);
	}        //main（）方法结束

}   //类Separator结束
