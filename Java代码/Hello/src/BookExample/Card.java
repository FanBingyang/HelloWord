package BookExample;

public class Card {
	private String face;
	private String suit;
	public Card(String cardFace,String cardSuit){
		face=cardFace;
		suit=cardSuit;
	}
	//��ʾһ����
	public String toString(){
		return suit+face;
	}
}
