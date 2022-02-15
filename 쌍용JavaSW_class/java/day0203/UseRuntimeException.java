package day0203;

public class UseRuntimeException {
	
	public void testRuntimeException(String[] args){
		try {
			
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;

			System.out.println(num1+ " / "+num2+" = "+result);
		}catch (Exception e) {
			System.out.println("개발자가 인지하지못한 예외발생");
		}
// 		Exception 하나만 써도 가능!
//		} catch (ArrayIndexOutOfBoundsException ae) {
//			System.err.println("예외발생: ArrayIndexOutOfBoundsException");
//			System.out.println("사용법) java UseRuntimeException");
//			ae.printStackTrace();
//		} catch(ArithmeticException ae) {
//			System.err.println("예외발생: ArithmeticException");
//			System.out.println("0으로 나눌 수 없습니다.");
//		} catch (NumberFormatException ne) {
//			System.err.println("예외발생: NumberFormatException");
//			if(ne.getMessage().contains("영")) {
//				System.out.println("한글입력");
//			}
		finally {
			//무조건 실행
			System.out.println("-----------------finally----------------");
			System.out.println("반드시 실행");
			
		}
		
	}//testRuntime
	
	public static void main(String[] args) {
		UseRuntimeException ure = new UseRuntimeException();
		ure.testRuntimeException(args);
	}
}
