package Market;

public class Main {

	public static void main(String[] args) {
			MarketGood g1 = new MarketGood("MacBook Air", 1250000);
	        MarketGood g2 = new MarketGood("MacBook Pro", 2990000, 15);
	        MarketGood g3 = new MarketGood("iPhone 7", 920000, 20);

	        System.out.println(g1.getName() + "�� ������: " + g1.getDiscountRate() + "%");
	        System.out.println(g2.getName() + "�� ������: " + g2.getDiscountRate() + "%");
	        System.out.println(g3.getName() + "�� ���� ����: " + g3.getRetailPrice() + "��");
	        System.out.println(g3.getName() + "�� ���� ����: " + g3.getDiscountedPrice() + "��");
	        System.out.println("���� ��ü�� �������� " + g3.getName() + "�� �������� 35%�� �ö����ϴ�.");
	        g3.setDiscountRate(35);
	        System.out.println(g3.getName() + "�� ���� ����: " + g3.getDiscountedPrice() + "��");

	}

}
