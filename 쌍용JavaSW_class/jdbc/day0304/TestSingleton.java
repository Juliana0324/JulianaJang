package day0304;

/**
 * 외부에서 객체화될수 없습니다.
 * @author user
 *1. 클래스 외부에서 직접 객체화 할수 없어야한다
 *2. 객체를 반환하는 method생성
 */
public class TestSingleton {
	private static TestSingleton ts;
	private TestSingleton() {
		
	}
	
	public static TestSingleton getInstance() {
		if(ts==null) {
			ts=new TestSingleton();
		}
		return ts;
	}
}
