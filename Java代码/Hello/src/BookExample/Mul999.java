package BookExample;
/*使用for语句的多重循环（循环语句中又有循环语句，称为多重循环）输出九九乘法表*/
public class Mul999 {
	public static void main(String args[]){
		int i;
		int j;
		int n=9;
		System.out.print("   *   |");              //输出"*    "
		for(i=1;i<=n;i++)                          //控制输出第1行
			System.out.print("   "+i);             //输出1数字~9，即第一个乘数
		System.out.print("\n-------|");            //输出"-------|"
		for(i=1;i<n;i++)                           //控制输出"-----"
			System.out.print("-----");
		System.out.println();
		for(i=1;i<=n;i++){                         //控制九次循环
			System.out.print("   "+i+"   |");      //输出每行的数，即另一个乘数
			for(j=1;j<=i;j++)                      //输出乘积数
				System.out.print("   "+i*j);       //输出具体的某个乘积
			System.out.println();
		}
	}

}
