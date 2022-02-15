package day0117;

/**
 * 자식클래스
 * 부모클래스 상속
 * 오버라이딩의 목적: 
 * 부모클래스가 제공하는 기능이 자식클래스에서 맞지 않으면 자식클래스가 필요한 기능을 재정의 하는것
 * 
 * 규칙:
 * 반환형, method명, 매개변수는 같을것
 * @author user
 *
 */
public class TestOverrideSub extends TestOverrideSuper{

	
	@Override
	public void temp() {
		System.out.println("자식클래스의 temp method");
	}
	
	public void sub() {
		System.out.println("자식클래스만 가진 method");
	}
	
	public String toString() {
		return "toString 메소드";
	}
	
	
}
