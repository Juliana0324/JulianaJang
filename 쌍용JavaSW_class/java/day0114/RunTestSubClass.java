package day0114;

/**
 * 클래스 사용클래스
 * @author user
 *
 */
public class RunTestSubClass {

	
	
	
	public static void main(String[] args) {
		TestSubClass child = new TestSubClass();

		child.parentResource();
		System.out.println();
		System.out.println("메임에서드에서 자식클래스의 객체로 "+child.a+", "+child.b+", "+child.c);
		
		
		
	}

}
