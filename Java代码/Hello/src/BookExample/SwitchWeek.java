package BookExample;
/*
     ���ܼ��:ʹ��switch����ж���������������ڼ���
 */
import java.util.Scanner;
public class SwitchWeek {
	public static void main(String arges[]){
		Scanner input=new Scanner(System.in);
		System.out.print("������1~7��������");
		int day=input.nextInt();      //Scanner������÷�����ȡһ����������
		switch(day)
		{
		case 7:System.out.println("������");break;
		case 6:System.out.println("������");break;
		case 5:System.out.println("������");break;
		case 4:System.out.println("������");break;
		case 3:System.out.println("������");break;
		case 2:System.out.println("���ڶ�");break;
		case 1:System.out.println("����һ");break;
		default:System.out.println("����������ڲ�����Ч��Χ�ڣ�");
		}
	}

}
