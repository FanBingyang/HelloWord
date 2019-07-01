package BookExample;
/*
    功能简介：使用if-else语句以及三元运算符，求3个数中的最大值喝最小值，，并输出结果。
 */
public class MaxMin {
	public static void main(String args[]){
			int max,min;
			int x=7,y=9,z=5;
			if(x>y)
				max=x;
			else
				max=y;
			if(z>max)
				max=z;
			System.out.println("最大值是："+max);
			min=x<y?x:y;
			min=z<min?z:min;
			System.out.println("最小值是："+min);
	}

}
