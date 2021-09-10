package BlackJack;

import java.util.ArrayList;

public class BlackjackHand extends Deck{

	public void addCard(BlackjackCard blackjackCard) {
		super.addCard(blackjackCard);
	}
	
	public int getValue() {
		int value=0;
		for(Card c: getCards()) {
			value+=((BlackjackCard)c).getValue();		
			if((c.getRank()).equals("Ace")) {
				if(value>21) {
					value-=10;
				}
			}
		}

		return value;
	
	}
	
	public boolean isBusted() {
		if(getValue()>21) {
			return true;
		}
		return false;
	}
	
	public boolean isBlackjack() {
//		if(hand.size() ==2 || hand.value==21) {
//			return true;
//		}
		if(getCards().size()<=2 && getValue()==21) {
			return true;
		}
		else return false;
	}

	
	
}
