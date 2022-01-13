package day0113;

/**
 * 메소드 형 - this
 * @author user
 *
 */
public class TestThisConstructor {

	public TestThisConstructor() {
		//this(1);
		System.out.println("기본 생성자");
		
	}//TestThisConstructor() 

	public TestThisConstructor(int i) {
		this();
		System.out.println("오버 로드된 생성자");
		
	}//TestThisConstructor(i) 
	
	
	
	public static void main(String[] args) {

//		오버 로드된 생성자
//		기본 생성자
//		new TestThisConstructor();

		
//		기본 생성자
//		오버 로드된 생성자
		new TestThisConstructor(5);
	}

}
