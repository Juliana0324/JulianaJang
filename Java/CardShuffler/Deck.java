package CardShuffler;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	
	private ArrayList<Card> cards;
	
	//카드 목록 리턴
	public ArrayList<Card> getCards(){
		return cards;
		
	}
	
	//cards에 추가
	public void addCard(Card newCard) {
		cards.add(newCard);
	}

	public void shuffle() {
		Random random = new Random();
		for(int i=0; i<cards.size();i++) {
			int rand = random.nextInt(cards.size());
			
			Card temp = cards.get(i);
			cards.set(i, cards.get(rand));
			cards.set(rand, temp);
		}
	}

	//먼저 hand라는 새로운 Deck 인스턴스를 만드세요. 
	// count가 5면 현재 덱의 cards의 마지막 다섯 장을 빼고, 
	// 그 다섯 장을 hand의 cards에 넣어주세요. 
	// 그리고 hand를 리턴해주면 됩니다.
	public Deck deal(int count) {
		Deck hand=new Deck();
		int size = cards.size();
		for(int i=size-1; i>=size-count; i--) {
				hand.addCard(cards.remove(i));
			}
		return hand;
	}

	//카드 목록에 있는 모든카드 출력
	public void print() {
		for (Card card : cards) {
            System.out.println(card.toString());
        }
	}

}
