package day0114;

/**
 * 부모클래스 호출관계
 * @author user
 *
 */
public class Parent {
	
	public Parent() {
		System.out.println("Parent: 부모의 기본생성자");

	}
	
	public Parent(int i) {
		this();
		System.out.println("부모의 오버로딩된 생성자"+i);
	}
	
}
