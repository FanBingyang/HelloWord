package BookExample;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
	public static void main(String[] args){
		//����һ���������ڱ���Random��������ɵ�һ��1~100������
		int game;
		//����һ���������ڱ�����Ҳµ���
		int guess;
		//����ͳ�ƲµĴ���
		int counter=0;
		Random randomNumbers=new Random();
		//randomNumbers�������nextInt()�������ɵ�һ���������
		//randomNumbers.nextInt(100)��ʾ����һ��1~99����������
		game=1+randomNumbers.nextInt(100);
		//ʵ����һ��Scanner��������ڻ�ȡ�������������
		Scanner input=new Scanner(System.in);
		do{
			System.out.println("������һ����µ����֣�1~100����������");
			//���÷�����ȡ�Ӽ������������
			guess=input.nextInt();
			counter++;
			if(guess==game)
				break;
			if(guess>game)
				System.out.println("��µ�����̫��");
			else
				System.out.println("��µ�����̫С��");
		}while(guess!=game);
		System.out.println("��ϲ�㣬�����"+counter+"�Σ���¶��ˣ�");
		}

	}

