package day0118;

public class UseAnonymous {

	/**
	 * 클래스 또는 인터페이스를 매게변수로 받는 method
	 * @param ta
	 */
	public void useTestA(TestA ta) {
		ta.testA();
	}
	
	
	public static void main(String[] args) {
		
//		1. 클래스를 객체화하여 
		UseAnonymous ua = new UseAnonymous();
		
		//3. 인터페이스를 구현한 클래스르 객체화
		TestAImpl tai = new TestAImpl();
		
		//4. 3번에서 생성된 객체를 arguments입력하여 method호출
		ua.useTestA(tai);
//		
		
//		//////////////Anonymous객체로 호출////////////////////
		UseAnonymous ua1 = new UseAnonymous();
		ua1.useTestA(new TestA() {
			
			@Override
			public void testA() {
				System.out.println("Anonymous객체를 이용하여 호출"); 
			}
		});
		
		
	}

}
