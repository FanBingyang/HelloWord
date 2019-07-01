package ShiYan_1;

public class GongYueShu1 {
	private int a;
	private int b;
	public void setA(int a){
		this.a=a;
	}
	public int getA(){
		return a;
	}
	public void setB(int b){
		this.b=b;
	}
	public int getB(){
		return b;
	}
	
	public int f(int a,int b){
		int temp;
		if(a<b)
		{
			temp=a;
			a=b;
			b=temp;
		}
		while(b!=0)
		{
			temp=a%b;
			a=b;
			b=temp;
		}
		return a;
	}

}
