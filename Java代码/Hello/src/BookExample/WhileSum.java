package BookExample;
/*
     ���ܼ�飺ʹ��while�����1~10�ĺͣ����������ӵĽ���ͱ���i��ֵ��
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
		System.out.println("1�ӵ�10�ĺ��ǣ�"+sum);
		System.out.println("ѭ�������i��ֵ�ǣ�"+i);
	}

}
