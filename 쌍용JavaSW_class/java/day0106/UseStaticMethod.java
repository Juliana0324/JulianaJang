package day0106;

/**
 * 
 * Static Method:인스턴스 변수를 사용하지 않고 입력된 값으로만 업무 처리를 할때 static메소드 사용
 * public static void Test
 * 
 * 
 *
 */
public class UseStaticMethod {
	public static void Test() {
		System.out.println("Test 정적메소드 호출됨");
		
	}
	public int intToChar(char n) {
		return n;
	}
	
	public static void main(String[] args) {
		//static 부를때는 .으로 호출
		UseStaticMethod.Test();
		
		//메소드 호출
		UseStaticMethod usm = new UseStaticMethod();
		System.out.println(usm.intToChar('A'));;
		
	}

}
