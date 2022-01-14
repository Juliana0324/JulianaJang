package day0114;

/** 
 * 부모클래스 : 자식이 사용할 공통 코드를 정의한다 => 코드의 재사용성
 * @author user
 *
 */
public class TestSuperClass{
	
	public int a;
	protected int b;
	int c;
	private int d;
	
	public TestSuperClass() {
		System.out.println("부모 클래스의 기본생성자");
	}//TestSuperClass
	
	public void parent() {
		System.out.println("부모의 method");
		
	}
	
	
}
