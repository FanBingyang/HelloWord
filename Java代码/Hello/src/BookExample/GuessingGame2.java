package BookExample;
import java.util.Scanner;
import java.util.Random;

public class GuessingGame2 {

	public static void main(String[] args) {
		int guess;
	    int game;
	    int count=0;
	    int i=3;
	    Random randomNumber=new Random();
	    Scanner input=new Scanner(System.in);
	    game=1+randomNumber.nextInt(100);
//	    System.out.println(game);
	    do{
	    	System.out.println("������һ��1~100��������");
	    	guess=input.nextInt();
	    	if(game==guess)
	    		System.out.println("��ϲ�㣬��¶��ˣ�");
	    	else{
	    		i--;
	    		System.out.println("�´���Ŷ���㻹��"+i+"�λ���");
	    		count++;
	    	}
	    	if(count==3){
	    		System.out.println("��������ˣ�");
	    		break;
	    	}
	    }while(game!=guess);
	}

}
