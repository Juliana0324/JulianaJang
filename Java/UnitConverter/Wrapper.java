package UnitConverter;

public class Wrapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer i = new Integer(123);
		Integer i1 = 123;
		
		System.out.println(123 == 123);	//true
		System.out.println(new Integer(123) == new Integer(123));//false
		
		 //참조형의 비교 연산자는 가리키는 객체가 같읕지 비교하기 때문입니다.
//		두 생성자를 통해 만든 다른 객체이기 때문
		
	}

}
