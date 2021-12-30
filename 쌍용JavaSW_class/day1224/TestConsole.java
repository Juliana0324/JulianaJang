/*
	콘솔 출력연습
*/

class TestConsole{
	public static void main(String[] args){
		/*
		main method를 가진 클래스는 단독으로 실행될 수 있는 클래스이다.	
		단독으로 실행 될수 있는 클래스를 어플리케이션이라고 한다.


		// System.out.print("안녕하세요? ");	
		// System.out.print("오늘은 크리스마스 이브입니다.");	

		//System.out.println("안녕하세요?");	
		//System.out.println("오늘은 크리스마스 이브입니다.");	
	
		System.out.println(25); //정수
		System.out.println(12.24); //실수
		System.out.println('A'); //문자
		System.out.println(true); //Boolean
 		System.out.println("Christmas"); //문자열
		*/
		
		System.out.println("변수");
		int i = 12;  //기본형
		TestConsole t = new TestConsole(); //참조형
		
		System.out.println(i);  // 기본형 데이터 : 
		System.out.println(t);  // 참조형 데이터 : 주소값

		System.out.println();
		System.out.println("연산식");
		System.out.println(12+24);
		System.out.println("문자열 상수의 결합 출력");
		System.out.println("12+24 = "+ (12+24));
		System.out.println();




	} //main

}//class