package BlackJack;

import java.util.ArrayList;

public class BlackjackHand extends Deck{

	public void addCard(BlackjackCard blackjackCard) {
		super.addCard(blackjackCard);
	}
	
/*
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
	*/
	//선생님 풀이
	
	public int getValue() {
		int value=0;
		//Ace가 몇장있나?
		int aceCount=0;
		
		for(Card c: getCards()) {
			BlackjackCard card = (BlackjackCard) c;
			if(card.isAce()) {
				aceCount++;
			}
			
			value+=card.getValue();
		}
		
		while(aceCount>0 && value>21) {
			value-=10;
			//몇번돌다가 aceCount=0이되면 빠져나옴
			aceCount--;
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

		if(getCards().size()<=2 && getValue()==21) {
			return true;
		}
		else return false;
	}

	
	
}
