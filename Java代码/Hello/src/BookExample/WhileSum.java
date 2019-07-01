package BookExample;
/*
     功能简介：使用while语句求1~10的和，并且输出相加的结果和变量i的值。
 */
public class WhileSum {
	public static void main(String args[]){
		int i=1;
		int n=10;
		int sum=0;
		while(i<=n)
		{
			sum+=i;
			i++;
		}
		System.out.println("1加到10的和是："+sum);
		System.out.println("循环后变量i的值是："+i);
	}

}
