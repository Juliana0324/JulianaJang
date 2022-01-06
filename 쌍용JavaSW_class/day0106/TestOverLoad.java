package day0106;

/**
 * method의 overload. 같은 읾의 method를 사용
 * 매개변수를 다르게
 * @author user
 *
 */
public class TestOverLoad {
	
	/**
	 * 별을 하나 출력하는 일
	 */
	public void printstar() {
		System.out.print("★ ");
	}
	
	/**
	 * 입력된 수대로 별 출력
	 * @param a
	 */
	public void printstar(int a) {
		for(int i=0;i<a;i++) {
			System.out.print("☆ ");
		}

	}
	
	public static void main(String[] args) {
		TestOverLoad tol = new TestOverLoad();
		tol.printstar();
		System.out.println();
		
		tol.printstar(5);
		
		
	}

}
