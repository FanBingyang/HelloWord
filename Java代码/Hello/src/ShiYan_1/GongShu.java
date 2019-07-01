package ShiYan_1;

public class GongShu {

	public static void main(String[] args) {
		int a=6;
		int b=4;
		GongYueShu1 yueshu=new GongYueShu1();
		GongBeiShu2 beishu=new GongBeiShu2();
		System.out.printf("有两个数分别是%d和%d\n",a,b);
		System.out.println("它们的最大公约数是："+yueshu.f(a, b));
		System.out.println("它们的最小公倍数是："+beishu.f(a, b));
	}

}
