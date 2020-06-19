package chap01.tuto;

import java.util.Random;

public class Apple {
	
	String [] colors= {"red","green","yellow"};
	String [] locations= {"����","���","����","��û"};
	
	int size;
	int weight;
	int color;
	int loc;
	
	@Override
	public String toString() {
		return String.format("[ũ��=%d, ���� =%d, ��=%s , ����=%s]",
					size,weight,colors[color],locations[loc]);
	}
	
	
	
	public String[] getColors() {
		return colors;
	}



	public void setColors(String[] colors) {
		Apple.colors = colors;
	}



	public static String[] getLocations() {
		return locations;
	}



	public static void setLocations(String[] locations) {
		Apple.locations = locations;
	}



	public int getSize() {
		return size;
	}



	public void setSize(int size) {
		this.size = size;
	}



	public int getWeight() {
		return weight;
	}



	public void setWeight(int weight) {
		this.weight = weight;
	}



	public int getColor() {
		return color;
	}



	public void setColor(int color) {
		this.color = color;
	}



	public int getLoc() {
		return loc;
	}



	public void setLoc(int loc) {
		this.loc = loc;
	}



	public Apple() {
		Random r=new Random();
		size =r.nextInt(11)+10;
		weight= r.nextInt(6)+10;
		color=r.nextInt(colors.length);
		loc=r.nextInt(locations.length);
	}
	public static void main(String [] args) {
		//println() : ��ü�� toString()�� ȣ���Ͽ� �� ����� �ֿܼ� ���
		//toString()�� Object�� �޼����̱� ������ ��� ��ü�� ������ �ִ�
		System.out.println(new Apple());	//chap01.tuto.Apple@6d06d69c
		
	}
}
