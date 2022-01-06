package day0106;

/**
 * method의 4가지 형태
 *
 */
public class TestMethodType {
	/**
	 * 1. 고정일: 반환형x 매개변수 없는 형
	 */
	public void typeA() {
		System.out.println("고정일: 호출을 하더라도 항상 같은 일을 수행한다");
	}	
	
	/**2. 가변일 : 반환형x 매개변수 있는 형
	 * 	 입력되는 값으로 동적인 일 수행가능
	 * @param i
	 */
	
	public void typeB(int i) {
		System.out.println(i+"를/을 호출");
		
	}

	/**
	 * 3. 고정값: 반환형o 매개변수 없는 형
	 * @return
	 */
	public int typeC() {
		int i=2022;
		return i;
	}

	/**
	 * 
	 * 4. 가변값: 반환형o 매개변수 있는 형 
	 * 매개변수에 따라 호출했을 때 다른 값 반환
	 */
	public int typeD(double n) {
		return (int)n;
	}
	
	//////////////////////////////////////////
	public static void main(String[] args) {
		TestMethodType tmt = new TestMethodType();
		tmt.typeA();
		tmt.typeB(10);
		System.out.println("고정값: "+tmt.typeC());
		
		int value1 = tmt.typeC();
		System.out.println("고정값: "+value1);
		
		System.out.println("가변값: "+tmt.typeD(10.4));
		int value2 = tmt.typeD(22.106);
		System.out.println("가변값: "+value2);
	}

}
