package day0203;

/**
 * throws를 사용한 예외 던짐,
 * 생성자, 일반 method, main method에 붙일 수 있다
 * 생성자에 throws붙이면 객체화(인스턴스)할때 처리합니다.
 * 
 * 일반method에서 throws를 붙이면 호출하는 곳에서 예외를 처리한다.
 * main메소드에 throw를 붙이면 JVM이 예외를 처리한다
 * @author user
 *
 */
public class UseThrows {
	
	/**
	 * 호출한 곳에서 메소드 내 발생한 예외를 처리하도록 throws 정의.
	 * @throws ClassNotFoundException
	 */
	public void work() throws ClassNotFoundException {
		Class.forName("java.lang.Integer1");
		System.out.println("클래스로딩 성공");
	}
	
	public void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
	

	public static void main(String[] args){
		UseThrows us =  new UseThrows();
//		try {
//			us.work();
//			
//		}catch (ClassNotFoundException cnfe) {
//			System.err.println("클래스가 존재하지 않습니다.");
//			cnfe.printStackTrace();
//		}
		
		try {
			for(int i=0; i<5; i++) {
				us.sleep();
				System.out.println(i);
			}
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}
}
