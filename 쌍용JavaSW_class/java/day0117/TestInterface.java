package day0117;

public interface TestInterface {
	//int i; //instance ���� ���x, �ʱ�ȭ�ô� ��밡��
	
	public static final int I= 100;

	
	//������ x
//	public TestInterface() {
//		�����ڸ� ������ x => ��üȭ�� ���� �ʴ´�.
//	}
	
//	public void test() {
//		�Ϲ� method ������ x
//	}
	
	
	public void test(); //abstract ���� abstract�޼ҵ�
	public abstract String test(int i); //abstract �ִ� abstract�޼ҵ�
	
	public default String temp() {
		return "JDK1.8 ���� �߰��� defualt�޼ҵ�";
	}
	
}
