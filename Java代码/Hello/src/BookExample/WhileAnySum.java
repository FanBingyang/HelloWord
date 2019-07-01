package BookExample;
import java.util.Scanner;
/*功能简介：用while语句求从键盘上输入的任意个double类型数值的和*/

public class WhileAnySum {
	public static void main(String  args[]){
		double x=0;
		double sum=0;
		int i=0;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入多个数，每个数后面按Enter或Tab键或空格键确认：");
		System.out.println("输入一个非数字符号结束输入操作!");
		while(input.hasNextDouble()){   //hasNextDouble()方法判断输入的数是不是double类型的数据
			x=input.nextDouble();       //获取数据
			sum+=x;
			i++;
		}
		System.out.println("共输入"+i+"个数，其和为："+sum);
	}

}
