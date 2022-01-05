package day0105.sub;

import day0105.Modifiers;

/**
 * 다른패키지의 다른클래스
 * 
 * @author user
 *
 */
public class Modifiers3 {
	
	public static void main(String[] args) {
		System.out.println("다른 패키지의 다른 클래스");
		
		Modifiers modi = new Modifiers();
		//변수의 접근 지정자에따라 사용과 사용불가가 결정됨
		
		modi.instanceA = 10;
		//modi.instanceB = 20;사용x
		//modi.instanceC = 30;사용x
		//modi.instanceD = 40; 사용불가
		System.out.println("public:"+ modi.instanceA);
		//System.out.println("protected:"+ modi.instanceB); 사용x
		//System.out.println("default:"+ modi.instanceC); 사용x
		//System.out.println("private:"+ modi.instanceD); 사용x
		
		
	}

}
