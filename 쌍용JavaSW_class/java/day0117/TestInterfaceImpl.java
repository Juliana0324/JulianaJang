package day0117;

/**
 * 인터페이스를 구현한 클래스
 * @author user
 *
 */
public class TestInterfaceImpl implements TestInterface {

	@Override
	public void test() {

		System.out.println("오버라이딩된 test메소드");
	}

	@Override
	public String test(int i) {
		// TODO Auto-generated method stub
		return String.valueOf(i);
	}
	

	public static void main(String[] args) {
//		TestInterface ti = new TestInterface();
	
		//default메소드는 static 메소드가 아니기때문에 직접호출x
//		TestInterface.temp();
		
		
		TestInterfaceImpl tii =new TestInterfaceImpl();
		System.out.println(tii.temp()); //default method
		
		tii.test();
		System.out.println(tii.test(2022));
		
		System.out.println("===============================");
		//is a 관계의 객체화
		TestInterface ti = new TestInterfaceImpl();
		System.out.println(ti.temp());
		tii.test();
		System.out.println(tii.test(2022));
		
	}

}
