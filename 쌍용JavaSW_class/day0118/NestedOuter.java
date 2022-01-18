package day0118;

/**
 * 중첩클래스(nested class)
 * @author user
 *
 */
public class NestedOuter {
	int outI;
	static int outJ;
	
	
	public void outInstanceMethod() {
		System.out.println("바깥클래스 메소드");
	}//out Instance method
	
	public static void outStaticMethod() {
		System.out.println("바깥클래스 static메소드");
	}//out staticmethod
	
	/////////////////////nested class 시작/////////////////
	static class NestedInner{
		static int inJ;
		
// 중첩클래스에서는 instance변수나 메소드를 만들지 x
//		int intI; //인스턴스변수 

//		public void innerInstanceMethod() {
//			System.out.println("이너클래스 메소드");
//		}//out Instance method
		
		public static void inStaticMethod() {
			System.out.println("중첩클래스 static메소드");
			
			//인스턴스 영역의 매소드는 사용불가
			//outI = 100;

		}//out staticmethod
		
		
	}
	
	/////////////////////nested class 끝/////////////////

	public static void main(String[] args) {
		//중첩클래스는 static을 주로 사용하지 않기떄문에 객체를 생성하지 x
		NestedInner.inJ = 100;
		NestedInner.inStaticMethod();
		
	}
}
