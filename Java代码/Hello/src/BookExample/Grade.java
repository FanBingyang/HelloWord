package BookExample;
import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		int SID;
		String name;
		float grade[]=new float [8];
		Scanner in=new Scanner(System.in);
		System.out.println("������ѧ��ѧ�ź�����:");
		SID=in.nextInt();
		name=in.next();
		System.out.println("������6������:");
		for(int i=0;i<=5;i++){
			grade[i]=in.nextFloat();
			grade[6]+=grade[i];
		}
		grade[7]=grade[6]/6;
		System.out.println("ѧ��ѧ��:"+SID+"   ѧ������:"+name);
		for(int i=0;i<=5;i++){
			System.out.println("����:"+grade[i]);
		}
		System.out.println("�ܳɼ�:"+grade[6]+"   ƽ���ɼ�:"+grade[7]);
	}

}
