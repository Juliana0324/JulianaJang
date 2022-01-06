package day0106;


/**
 * 
 * class field에 선언되는 변수는 자동초기화가 된다
 * 개발자는 초기값을 넣을 필요없다
 * @author user
 *
 */
public class TestDefaultValue {
	int i; //정수형 = 0;
	char c; //문자형 = \u0000(공백)
	double d; //실수형 = 0.0
	boolean b; // false 
	
	TestDefaultValue tdv; //참조형 Null
	String str; //참조형 null
	int[] arr; //참조형 null
	
	public static void main(String[] args) {
		TestDefaultValue instance = new TestDefaultValue();
		System.out.println(instance.i);
		System.out.println(instance.c);
		System.out.println(instance.d);
		System.out.println(instance.b);
		System.out.println(instance.tdv);
		System.out.println(instance.str);
		System.out.println(instance.arr);
		
		
		
	}//main

}//class
