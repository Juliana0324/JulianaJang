package day0118;

/**
 * inner class
 * @author user
 *
 */
public class Outer {
	
	private int outI;
	
	public Outer() {
		System.out.println("바깥클래스의 생성자");
	}//생성자
	
	public void outMethod() {
		System.out.println("바깥 클래스의 method");
//		inI = 10; 밖 클래스에서는 안쪽 클래스의 변수를 직접 사용할 수 없음
//		innerMethod(); 밖 클래스에서는 안쪽 클래스의 메소드를 직접 사용할 수 없음
		
		System.out.println("--------------------------------------");
		//INSTANCE method에서 innerClass를 객체화해보기
		Inner in = new Inner();
		in.inI = 100;
		System.out.println(in);
		
		
	} //outMethod
	
	
	
	///////////////안쪽 클래스 시작///////////////
	public class Inner{
		int inI;
		
		public Inner() {
			outI = 10;
			System.out.println("안쪽클래스의 생성자"+ outI);
			
		} //생성자
		
		public void innerMethod() {
			System.out.println("안쪽 클래스의 method "+inI);
		}//innerMethod		
		
	}
	
	///////////////안쪽 클래스 끝///////////////

	public static void main(String[] args) {
		//1. 바깥 클래스 먼저 객체화
		Outer out = new Outer();
		//2. 이너클래스 객체화
		Inner in = out.new Inner();
		out.outMethod();
		in.inI = 200;
		in.innerMethod();
		
		
		
		
	}
	
	
}
