package day0105;

/**
 * Instance Method�� �ۼ��ϰ� ȣ��
 * 
 * 
 */
public class UseInstanceMethod {

	/**
	 * �ν��Ͻ� �޼ҵ� ���� 
	 */
	public void test() {
		System.out.println("test�޼ҵ� ȣ��");
	}
	
//	�� public void m() {
//		test();
//	} static������ �ƴϸ� ����
	
	public static void main(String[] args) {
		//�� test(); -- static���������� instance method�� ����� �� x
		
		UseInstanceMethod uim = new UseInstanceMethod();
		uim.test();
		
	}
	
}