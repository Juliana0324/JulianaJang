package day0117;

public interface TestInterface {
	//int i; //instance 변수 사용x, 초기화시는 사용가능
	
	public static final int I= 100;

	
	//생성자 x
//	public TestInterface() {
//		생성자를 가질수 x => 객체화가 되지 않는다.
//	}
	
//	public void test() {
//		일반 method 가질수 x
//	}
	
	
	public void test(); //abstract 없는 abstract메소드
	public abstract String test(int i); //abstract 있는 abstract메소드
	
	public default String temp() {
		return "JDK1.8 이후 추가된 defualt메소드";
	}
	
}
