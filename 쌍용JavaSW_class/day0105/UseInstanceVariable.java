package day0105;

/**
 * 인스턴스 변수
 * 1. 선언: 접근지정자 데이터형 변수명();
 * 2. 객체 생성: 클래스명 객체명 = new 클래스명();
 * 3. 객체 명으로 변수에 값 할당 : 객체명.변수명 = 값;
 * @author user
 */
public class UseInstanceVariable {
 int i; //default 접근지정자를 가진 인스턴스/멤버변수
 
 public static void main(String[] args) {
//	 System.out.println(i); // 인스턴스 변수는 static 영역에서 객체명 없이 직접사용x
	 //2. 객체화.int
	 //생성된 객체는 같은이름의 변수 i를 가짐
	 UseInstanceVariable uiv = new UseInstanceVariable();
	 
	 //값할당.
	 uiv.i = 2022;
	 System.out.println(uiv.i);

	 UseInstanceVariable uiv1 = new UseInstanceVariable();
	 UseInstanceVariable uiv2 = new UseInstanceVariable();
	 uiv1.i = 1;
	 uiv2.i = 5;
	 System.out.println(uiv1.i);
	 System.out.println(uiv2.i);

	 
	 
 }

}
