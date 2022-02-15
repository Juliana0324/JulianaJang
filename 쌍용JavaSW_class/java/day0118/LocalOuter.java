package day0118;

/**
 * 로컬클래스
 * @author user
 *
 */
public class LocalOuter {
	
	int outI;
	
	public void method1(int parami, final int paramJ) {
		int localA = 2022;
		final int localB = 1;
//		paramJ = 200; final -> 쓸수 없음
	
		///////////////////////로컬변수///////////////////////////
		class LocalInner{
			int i;

			public LocalInner() {
				System.out.println("지역클래스 생성자");
			}
			
			public void localMethod() {
				System.out.println("지역클래스의 method");
				System.out.println("바깥 클래스의 instance I"+outI);
				
				
				//JDK1.8이후부터 지역클래스에서 final이 명시되지 않은 변수를 사용할 수 있게되었다.
				//parami = 10; 
				System.out.println("method에서의 파라미터: "+parami+", "+paramJ);
				
				//localA = 10;
				System.out.println("method에서의 지역변수: "+localA+", "+localB);
				
			}//Method
			
		}//Inner class
		///////로컬변수 끝///////////

		
		LocalInner lo = new LocalInner();
		lo.i = 49;
		System.out.println(lo.i);
		lo.localMethod();		
		
	}	
	
	public static void main(String[] args) {
		LocalOuter loc = new LocalOuter();
		loc.method1(100, 300);
		

		
		

		
	}

}
