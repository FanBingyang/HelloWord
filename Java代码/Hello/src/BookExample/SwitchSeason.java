package BookExample;
/*
    功能简介：使用switch语句判断某月属于哪个季节。
 */
import java.util.Scanner;
public class SwitchSeason {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("请输入1~12的整数：");
		int month=input.nextInt();
		switch(month)
		{
		   case 3:    //空语句，无操作继续检查下一个case检查
		   case 4:
		   case 5:System.out.println("春季");break;
		   case 6:
		   case 7:
		   case 8:System.out.println("夏季");break;
		   case 9:
		   case 10:
		   case 11:System.out.println("秋季");break;
		   case 12:
		   case 1:
		   case 2:System.out.println("冬季");break;
		   default:System.out.println("你输入的月份不在有效范围内！");
		}
	}

}
