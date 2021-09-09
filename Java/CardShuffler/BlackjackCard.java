package CardShuffler;

public class BlackjackCard {

	private int c;
	private int value;

	public BlackjackCard(int card, int value) {
		this.c = card;
		this.value = value;
	}

	public int getValue() {
		Card card = new Card(c, value);
		switch(card.getRank()){
		case "Ace":
			return 11;
		case "Jack":
			return 10;
		case "Queen":
			return 10;
		case "King":
			return 10;
		
		default:
			return card.rankNumber;
		}
		
	}
	
	
	public boolean isAce() {
		Card card = new Card(c, value);
		if(card.getRank().equals("Ace")) {
			return true;
		}
		else return false;
		
	}
	
}
