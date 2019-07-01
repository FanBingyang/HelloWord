package BookExample;

public class Card {
	private String face;
	private String suit;
	public Card(String cardFace,String cardSuit){
		face=cardFace;
		suit=cardSuit;
	}
	//œ‘ æ“ª’≈≈∆
	public String toString(){
		return suit+face;
	}
}
