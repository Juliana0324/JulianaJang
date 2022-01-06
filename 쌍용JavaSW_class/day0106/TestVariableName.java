package day0106;

/**
 * 같은 이름의 변수를 사용했을때 error
 * @author user
 *
 */
public class TestVariableName {
	/**
	 * class field : instance variable, static(class) variable
	 * class field에 선언되는 변수의 이름은 유일하다.
	 * 
	 */
	int i;
	static int j;
	
	public static void main(String[] args) {
		//local
		//지역은 class field와 역역이 다르기 떄문에 
		// class field에 선언된 이름을 같은변수로 사용가능
		int i=10;
		System.out.println(i);
		
		TestVariableName tvn = new TestVariableName();
		System.out.println(tvn.i);
		
		
		
	}//

}//
