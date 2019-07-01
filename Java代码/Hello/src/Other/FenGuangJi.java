package Other;

public class FenGuangJi {
	
	public static void main(String[] args) {
		double[] d = {120.017,120.067,120.1,120.033,120.017,120.0};//补角的值
		double D = 120.033;	//补角平均值
		double sum = 0;
		double b = 0;//标准差
		double A,B,C;//A、B类不确定度,合成不确定度
		for (int i = 0; i < d.length; i++) {
			sum += Math.pow((d[i]-D), 2);
		}
		b = Math.sqrt(sum/5) * 60;
		System.out.println("标准差为："+(int)b+"'"+(int)((b-(int)b)*60)+"\"");
		A = b/Math.sqrt(6) * 60;
		System.out.println("A类不确定度为："+(int)A+"\"");
		B = 60 * 1.0/(Math.sqrt(3));
		System.out.println("B类不确定度为："+(int)B+"\"");
		C = Math.sqrt((Math.pow((2.57*A/60),2)) + (Math.pow((1.96*B/60), 2)));
		System.out.println("合成不确定度为："+(int)C+"'"+(int)((C-(int)C)*60)+"\"");
		System.out.println(); 
	}
}
