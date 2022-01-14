package day0114;

/**
 * parent의 자식클래스
 * @author user
 *
 */
public class Child extends Parent{
	
	public Child() {
		super(20);
		System.out.println("child: 자식의 기본생성자");
	}
	
	public Child(int i) {		
		super();
		System.out.println("자식의 오버로딩된 생성자 "+ i);
	}// child
	
}
