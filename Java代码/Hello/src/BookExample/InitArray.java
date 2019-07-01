package BookExample;

public class InitArray {

	public static void main(String[] args) {
		int array[];
		array=new int[10];
		System.out.printf("%s%8s\n","数组元素","对应的值");
		for(int i=0;i<array.length;i++)
		{
			System.out.printf("%5d%8d\n",i,array[i]);
		}
	}

}
