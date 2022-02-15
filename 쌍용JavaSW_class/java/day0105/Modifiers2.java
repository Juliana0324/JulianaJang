package day0105;

/**
 * 같은패키지의 다른클래스
 * 
 * @author user
 *
 */
public class Modifiers2 {
	
	public static void main(String[] args) {
		System.out.println("같은 패키지의 다른 클래스");
		Modifiers modi = new Modifiers();
		//변수의 접근 지정자에따라 사용과 사용불가가 결정됨
		
		modi.instanceA = 10;
		modi.instanceB = 20;
		modi.instanceC = 30;
		//modi.instanceD = 40; 사용불가
		System.out.println("public:"+ modi.instanceA);
		System.out.println("protected:"+ modi.instanceB);
		System.out.println("default:"+ modi.instanceC);
		//System.out.println("private:"+ modi.instanceD); 사용x
		
		
	}

}
