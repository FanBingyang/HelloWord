package BookExample;

public class DeckOfCardTest {
	public static void main(String args[]){
		DeckOfCard myDeckOfCards=new DeckOfCard();
		myDeckOfCards.shuffle();
		System.err.printf("%-20s%-20s%-20s%-20s\n","���1","���2","���3","���4");
		System.out.println();
		for(int i=0;i<13;i++)
			System.out.printf("%-20s%-20s%-20s%-20s\n",myDeckOfCards.dealCard(),myDeckOfCards.dealCard(),myDeckOfCards.dealCard(),myDeckOfCards.dealCard());
	}

}
