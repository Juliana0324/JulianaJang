package day0105;

/**
 * 멤버변수의 접근지정자
 * 
 * @author user
 *
 */
public class Modifiers {
	public int instanceA; //패키지 상관x
	protected int instanceB; //같은 패키지의 클래스에서 접근가능
							// 패키지가 다르면 상속관계의 자식클래스에서만 접근가능
	int instanceC;			// 같은 패키지의 클래스에서 접근가능
	private int instanceD; // 클래스안에서만 접근가능
	
	
	public static void main(String[] args) {
		Modifiers modi = new Modifiers();
		//변수를 가진 클래스안에서는 접근지정자와 상관없이 사용가능
		
		modi.instanceA = 10;
		modi.instanceB = 20;
		modi.instanceC = 30;
		modi.instanceD = 40;
		System.out.println("public:"+ modi.instanceA);
		System.out.println("protected:"+ modi.instanceB);
		System.out.println("default:"+ modi.instanceC);
		System.out.println("private:"+ modi.instanceD);
		
		
	}

}
