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
	    	System.out.println("请输入一个1~100的整数：");
	    	guess=input.nextInt();
	    	if(game==guess)
	    		System.out.println("恭喜你，你猜对了！");
	    	else{
	    		i--;
	    		System.out.println("猜错了哦，你还有"+i+"次机会");
	    		count++;
	    	}
	    	if(count==3){
	    		System.out.println("这局你输了！");
	    		break;
	    	}
	    }while(game!=guess);
	}

}
