package day0203;

/**
 * compile exception: 
 * 코딩시에 발생하는 예외(byte코드가 제대로 만들어지지 않는 문제 있음)
 * @author user
 */
public class UseCompileException {
	
	public UseCompileException() {
		//new를 사용하지 않고 외부클래스를 객체로 생성할때
		try {
//			Class obj= Class.forName("java.lang.String");
			Class obj= Class.forName("day0203.UseRuntimeException1");
			System.out.println(obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("class의 이름을 확인하세요");
			String msg = cnfe.getMessage();
			System.err.println("간단한 메세지: "+msg);
			
			String msg1 = cnfe.toString();
			System.err.println("예외처리 객체와 간단한 메세지: "+msg1);
			cnfe.printStackTrace();
			System.out.println("===========================================");
		}
		
	}
	
	public static void main(String[] args) {
		new UseCompileException();
	}
}
