package BookExample;
/*
     功能简介:使用switch语句判断输入的数字是星期几。
 */
import java.util.Scanner;
public class SwitchWeek {
	public static void main(String arges[]){
		Scanner input=new Scanner(System.in);
		System.out.print("请输入1~7的整数：");
		int day=input.nextInt();      //Scanner对象调用方法获取一个整数数据
		switch(day)
		{
		case 7:System.out.println("星期日");break;
		case 6:System.out.println("星期六");break;
		case 5:System.out.println("星期五");break;
		case 4:System.out.println("星期四");break;
		case 3:System.out.println("星期三");break;
		case 2:System.out.println("星期二");break;
		case 1:System.out.println("星期一");break;
		default:System.out.println("你输入的日期不在有效范围内！");
		}
	}

}
