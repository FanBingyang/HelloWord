package BookExample;
import java.util.Scanner;
/*���ܼ�飺��while�����Ӽ���������������double������ֵ�ĺ�*/

public class WhileAnySum {
	public static void main(String  args[]){
		double x=0;
		double sum=0;
		int i=0;
		Scanner input=new Scanner(System.in);
		System.out.println("������������ÿ�������水Enter��Tab����ո��ȷ�ϣ�");
		System.out.println("����һ�������ַ��Ž����������!");
		while(input.hasNextDouble()){   //hasNextDouble()�����ж���������ǲ���double���͵�����
			x=input.nextDouble();       //��ȡ����
			sum+=x;
			i++;
		}
		System.out.println("������"+i+"���������Ϊ��"+sum);
	}

}
