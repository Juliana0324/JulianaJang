package day0117;

/**
 * 객체화가 되지 않는 클래스
 * @author user
 *
 */
public abstract class AbstractSuper {
	
	int i;
	public AbstractSuper() { //자식클래스에서만 호출됨
		System.out.println("추상클래스의 생성자");
	}
	
	public void methodA() {
		System.out.println("일반 메소드");
	}
	
	public abstract void methodB(); //추상 메소드 => 바디가 없음
	
	public abstract int methodC(String name); //추상 메소드 => 바디가 없음

	//	public static void main(String[] args) {
		//new AbstractSuper();

	
	//}//main
}
