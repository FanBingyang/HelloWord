package ShiYan_1;

public class GongShu {

	public static void main(String[] args) {
		int a=6;
		int b=4;
		GongYueShu1 yueshu=new GongYueShu1();
		GongBeiShu2 beishu=new GongBeiShu2();
		System.out.printf("���������ֱ���%d��%d\n",a,b);
		System.out.println("���ǵ����Լ���ǣ�"+yueshu.f(a, b));
		System.out.println("���ǵ���С�������ǣ�"+beishu.f(a, b));
	}

}
