package BookExample;
import java.util.Random;

public class DeckOfCard {
	private Card deck[];
	private int currentCard;
	private final int NUMBER_OF_CARDS=52;
	private Random randomNnmbers;
	public DeckOfCard(){
		String faces[]={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String suits[]={"ºÚÌÒ","ºìÌÒ","Ã·»¨","·½¿é"};
		deck=new Card[NUMBER_OF_CARDS];
		currentCard=0;
		randomNnmbers=new Random();
		for(int count=0;count<deck.length;count++)
			deck[count]=new Card(faces[count%13],suits[count/13]);
	}
	
	public void shuffle(){
		currentCard=0;
		for(int first=0;first<deck.length;first++){
			int second=randomNnmbers.nextInt(NUMBER_OF_CARDS);
			Card temp=deck[first];
			deck[first]=deck[second];
			deck[second]=temp;
		}
	}
	public Card dealCard(){
		if(currentCard<deck.length)
			return deck[currentCard++];
		else
			return null;
	}

}
