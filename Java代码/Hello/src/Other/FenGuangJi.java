package Other;

public class FenGuangJi {
	
	public static void main(String[] args) {
		double[] d = {120.017,120.067,120.1,120.033,120.017,120.0};//���ǵ�ֵ
		double D = 120.033;	//����ƽ��ֵ
		double sum = 0;
		double b = 0;//��׼��
		double A,B,C;//A��B�಻ȷ����,�ϳɲ�ȷ����
		for (int i = 0; i < d.length; i++) {
			sum += Math.pow((d[i]-D), 2);
		}
		b = Math.sqrt(sum/5) * 60;
		System.out.println("��׼��Ϊ��"+(int)b+"'"+(int)((b-(int)b)*60)+"\"");
		A = b/Math.sqrt(6) * 60;
		System.out.println("A�಻ȷ����Ϊ��"+(int)A+"\"");
		B = 60 * 1.0/(Math.sqrt(3));
		System.out.println("B�಻ȷ����Ϊ��"+(int)B+"\"");
		C = Math.sqrt((Math.pow((2.57*A/60),2)) + (Math.pow((1.96*B/60), 2)));
		System.out.println("�ϳɲ�ȷ����Ϊ��"+(int)C+"'"+(int)((C-(int)C)*60)+"\"");
		System.out.println(); 
	}
}
