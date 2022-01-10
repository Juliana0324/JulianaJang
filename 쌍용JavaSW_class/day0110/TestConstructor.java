package day0110;

/**
 * �������� ���ǿ� ȣ��
 * @author user
 *
 */
public class TestConstructor {
	private int i; //�ν��Ͻ� ����, ��üȭ �Ҷ� heap�޸𸮿� �ڵ��ʱ�ȭ �Ǿ� �ö󰣴�.
	
	
	public TestConstructor() {
		//��ü�� �����ɶ� �ν��Ͻ� ������ ���� 2022�� �ʱ�ȭ �ϰ�ʹ�
		i = 2022;
		System.out.println("�⺻������");
	}
	
	
	/**
	 * �������� Overload : ���������� ����, ��ȯ�� ���� �޼ҵ�� ������, �Ű������� �ٸ���
	 * @param i ��ü�� ���� �ɶ� �� �ʱⰪ
	 */
	public TestConstructor(int i) {
		this.i= i;
		System.out.println("�μ��ִ� ������");
		test(); //�Ϲ� methodȣ��
//		TestConstructor(); //�����ڴ� ���� ȣ�� �Ұ�
	}

	public void test() {
		System.out.println("test method!");
	}
	
	public static void main(String[] args) {
		TestConstructor tc=new TestConstructor(); //�⺻ ������ ����Ͽ� ��üȭ
		System.out.println(tc.i);
		
		TestConstructor tc1 = new TestConstructor(110);
		System.out.println(tc1.i);
				

	}

}
