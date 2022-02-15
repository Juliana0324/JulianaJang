package day0114;

/**
 * 자식클래스
 * @author user
 *
 */
public class TestSubClass extends TestSuperClass{
	
	int c;
	
	public TestSubClass() {
		System.out.println("자식클래스 생성자");
	}
	
	public void parentResource() {
		//상속의 특징: 부모클래스의 자원을 자식클래스에서 자신의 것처럼 사용할 수 있음
		
		this.a = 10; //public
		this.b =20; // protected
		this.c= 30; //TestSub내부의 인스턴스 변수
		super.c = 40; // TestSuper클래스
		
		System.out.printf("a: %d, b: %d, c: %d, super.c : %d", a,b,c, super.c);
	}
	
}
