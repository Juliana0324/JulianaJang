package day0203;

public class UseRuntimeException {
	
	public void testRuntimeException(String[] args){
		try {
			
			int num1 = Integer.parseInt(args[0]);
			int num2 = Integer.parseInt(args[1]);
			int result = num1/num2;

			System.out.println(num1+ " / "+num2+" = "+result);
		}catch (Exception e) {
			System.out.println("�����ڰ� ������������ ���ܹ߻�");
		}
// 		Exception �ϳ��� �ᵵ ����!
//		} catch (ArrayIndexOutOfBoundsException ae) {
//			System.err.println("���ܹ߻�: ArrayIndexOutOfBoundsException");
//			System.out.println("����) java UseRuntimeException");
//			ae.printStackTrace();
//		} catch(ArithmeticException ae) {
//			System.err.println("���ܹ߻�: ArithmeticException");
//			System.out.println("0���� ���� �� �����ϴ�.");
//		} catch (NumberFormatException ne) {
//			System.err.println("���ܹ߻�: NumberFormatException");
//			if(ne.getMessage().contains("��")) {
//				System.out.println("�ѱ��Է�");
//			}
		finally {
			//������ ����
			System.out.println("-----------------finally----------------");
			System.out.println("�ݵ�� ����");
			
		}
		
	}//testRuntime
	
	public static void main(String[] args) {
		UseRuntimeException ure = new UseRuntimeException();
		ure.testRuntimeException(args);
	}
}
