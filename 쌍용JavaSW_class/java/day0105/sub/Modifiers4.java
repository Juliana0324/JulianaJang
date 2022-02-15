package day0105.sub;

import day0105.Modifiers;

/**
 * 다른패키지 자식클래스
 * 
 * @author user
 *
 */
public class Modifiers4 extends Modifiers{
	
	public static void main(String[] args) {
		System.out.println("다른 패키지의 자식클래스");
		
		//상속관계에서는 자식클래스로 객체화를 합니다.
		Modifiers4 modi = new Modifiers4();
		//변수의 접근 지정자에따라 사용과 사용불가가 결정됨
		
		
		modi.instanceA = 10;
		modi.instanceB = 20;
//		modi.instanceC = 30; 사용x
//		modi.instanceD = 40; 사용x
		System.out.println("public:"+ modi.instanceA);
		System.out.println("protected:"+ modi.instanceB);
//		System.out.println("default:"+ modi.instanceC); 사용x
//		System.out.println("private:"+ modi.instanceD); 사용x
		
		
	}

}
