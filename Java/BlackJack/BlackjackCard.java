package BlackJack;

public class BlackjackCard extends Card{

	private int c;
	private int value;

	
	public BlackjackCard(int suitNumber, int rankNumber) {
		super(suitNumber, rankNumber);
	}
	
	public int getValue() {
		switch(rankNumber) {
			case 1:
				return 11;
			case 11:
				return 10;
			case 12:
				return 10;
			case 13:
				return 10;
			default:
				return rankNumber;
			
			}	
		}
	
	public boolean isAce() {
	//	Card card = new Card(c, value);
	//	if(card.getRank().equals("Ace")) {
	//		return true;
	//	}
	//	else return false;
		
		return rankNumber ==1;
		
	}
	
		
		
	
}
