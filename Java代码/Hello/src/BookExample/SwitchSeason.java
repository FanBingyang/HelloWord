package BookExample;
/*
    ���ܼ�飺ʹ��switch����ж�ĳ�������ĸ����ڡ�
 */
import java.util.Scanner;
public class SwitchSeason {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("������1~12��������");
		int month=input.nextInt();
		switch(month)
		{
		   case 3:    //����䣬�޲������������һ��case���
		   case 4:
		   case 5:System.out.println("����");break;
		   case 6:
		   case 7:
		   case 8:System.out.println("�ļ�");break;
		   case 9:
		   case 10:
		   case 11:System.out.println("�＾");break;
		   case 12:
		   case 1:
		   case 2:System.out.println("����");break;
		   default:System.out.println("��������·ݲ�����Ч��Χ�ڣ�");
		}
	}

}
