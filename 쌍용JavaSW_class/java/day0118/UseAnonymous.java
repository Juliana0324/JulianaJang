package day0118;

public class UseAnonymous {

	/**
	 * Ŭ���� �Ǵ� �������̽��� �ŰԺ����� �޴� method
	 * @param ta
	 */
	public void useTestA(TestA ta) {
		ta.testA();
	}
	
	
	public static void main(String[] args) {
		
//		1. Ŭ������ ��üȭ�Ͽ� 
		UseAnonymous ua = new UseAnonymous();
		
		//3. �������̽��� ������ Ŭ������ ��üȭ
		TestAImpl tai = new TestAImpl();
		
		//4. 3������ ������ ��ü�� arguments�Է��Ͽ� methodȣ��
		ua.useTestA(tai);
//		
		
//		//////////////Anonymous��ü�� ȣ��////////////////////
		UseAnonymous ua1 = new UseAnonymous();
		ua1.useTestA(new TestA() {
			
			@Override
			public void testA() {
				System.out.println("Anonymous��ü�� �̿��Ͽ� ȣ��"); 
			}
		});
		
		
	}

}
