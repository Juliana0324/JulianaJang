package day0117;

public class UsePoly {

	/** 
	 * 객체 다형성을 사용하기 위한 method
	 * @param tp
	 */
	public void usePoly(TestPoly tp) {
		//tp라는 객체를 사용하는데 다른 결과를 얻는것.
		
		tp.polymorphism();
		
	}
	
	public static void main(String[] args) {
		//객체의 다형성
		// 입력되는 객체에 따라 다른 일을 수행
		UsePoly up = new UsePoly();
		up.usePoly(new TestPoly2());
		up.usePoly(new TestPoly3());
		up.usePoly(new TestPoly());

	}//main

}
