package day0113;

/**
 * �޼ҵ� �� - this
 * @author user
 *
 */
public class TestThisConstructor {

	public TestThisConstructor() {
		//this(1);
		System.out.println("�⺻ ������");
		
	}//TestThisConstructor() 

	public TestThisConstructor(int i) {
		this();
		System.out.println("���� �ε�� ������");
		
	}//TestThisConstructor(i) 
	
	
	
	public static void main(String[] args) {

//		���� �ε�� ������
//		�⺻ ������
//		new TestThisConstructor();

		
//		�⺻ ������
//		���� �ε�� ������
		new TestThisConstructor(5);
	}

}
