package day0105;

/**
 * Instance Method를 작성하고 호출
 * 
 * 
 */
public class UseInstanceMethod {

	/**
	 * 인스턴스 메소드 생성 
	 */
	public void test() {
		System.out.println("test메소드 호출");
	}
	
//	★ public void m() {
//		test();
//	} static영역이 아니면 가능
	
	public static void main(String[] args) {
		//★ test(); -- static영역에서는 instance method를 출력할 수 x
		
		UseInstanceMethod uim = new UseInstanceMethod();
		uim.test();
		
	}
	
}