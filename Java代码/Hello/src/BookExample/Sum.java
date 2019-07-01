package BookExample;

public class Sum {
	public static void main(String args[]){
		int i=1,n=10,s=0;
		System.out.print("Sum("+n+")=");
		for(i=1;i<n;i++)
		{
			s+=i;
			System.out.print(i+"+");
		}
		System.out.println(i+"="+(s+i));
	}

}
