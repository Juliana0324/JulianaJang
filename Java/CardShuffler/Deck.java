package CardShuffler;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	public Deck() {
		cards = new ArrayList<Card>();
	}
	
	
	private ArrayList<Card> cards;
	
	//ī�� ��� ����
	public ArrayList<Card> getCards(){
		return cards;
		
	}
	
	//cards�� �߰�
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

	//���� hand��� ���ο� Deck �ν��Ͻ��� ���弼��. 
	// count�� 5�� ���� ���� cards�� ������ �ټ� ���� ����, 
	// �� �ټ� ���� hand�� cards�� �־��ּ���. 
	// �׸��� hand�� �������ָ� �˴ϴ�.
	public Deck deal(int count) {
		Deck hand=new Deck();
		int size = cards.size();
		for(int i=size-1; i>=size-count; i--) {
				hand.addCard(cards.remove(i));
			}
		return hand;
	}

	//ī�� ��Ͽ� �ִ� ���ī�� ���
	public void print() {
		for (Card card : cards) {
            System.out.println(card.toString());
        }
	}

}
