package BookExample;
/*
    ���ܼ�飺ʹ��if-else����Լ���Ԫ���������3�����е����ֵ����Сֵ��������������
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
			System.out.println("���ֵ�ǣ�"+max);
			min=x<y?x:y;
			min=z<min?z:min;
			System.out.println("��Сֵ�ǣ�"+min);
	}

}
