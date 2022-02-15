package day0110;

/**
 * 생성자의 정의와 호출
 * @author user
 *
 */
public class TestConstructor {
	private int i; //인스턴스 변수, 객체화 할때 heap메모리에 자동초기화 되어 올라간다.
	
	
	public TestConstructor() {
		//객체가 생성될때 인스턴스 변수의 값을 2022로 초기화 하고싶다
		i = 2022;
		System.out.println("기본생성자");
	}
	
	
	/**
	 * 생성자의 Overload : 접근지정자 같고, 반환형 같고 메소드명 같지만, 매개변수는 다르게
	 * @param i 객체가 생성 될때 들어갈 초기값
	 */
	public TestConstructor(int i) {
		this.i= i;
		System.out.println("인수있는 생성자");
		test(); //일반 method호출
//		TestConstructor(); //생성자는 직접 호출 불가
	}

	public void test() {
		System.out.println("test method!");
	}
	
	public static void main(String[] args) {
		TestConstructor tc=new TestConstructor(); //기본 생성자 사용하여 객체화
		System.out.println(tc.i);
		
		TestConstructor tc1 = new TestConstructor(110);
		System.out.println(tc1.i);
				

	}

}
