package day0118;

/**
 * inner class
 * @author user
 *
 */
public class Outer {
	
	private int outI;
	
	public Outer() {
		System.out.println("�ٱ�Ŭ������ ������");
	}//������
	
	public void outMethod() {
		System.out.println("�ٱ� Ŭ������ method");
//		inI = 10; �� Ŭ���������� ���� Ŭ������ ������ ���� ����� �� ����
//		innerMethod(); �� Ŭ���������� ���� Ŭ������ �޼ҵ带 ���� ����� �� ����
		
		System.out.println("--------------------------------------");
		//INSTANCE method���� innerClass�� ��üȭ�غ���
		Inner in = new Inner();
		in.inI = 100;
		System.out.println(in);
		
		
	} //outMethod
	
	
	
	///////////////���� Ŭ���� ����///////////////
	public class Inner{
		int inI;
		
		public Inner() {
			outI = 10;
			System.out.println("����Ŭ������ ������"+ outI);
			
		} //������
		
		public void innerMethod() {
			System.out.println("���� Ŭ������ method "+inI);
		}//innerMethod		
		
	}
	
	///////////////���� Ŭ���� ��///////////////

	public static void main(String[] args) {
		//1. �ٱ� Ŭ���� ���� ��üȭ
		Outer out = new Outer();
		//2. �̳�Ŭ���� ��üȭ
		Inner in = out.new Inner();
		out.outMethod();
		in.inI = 200;
		in.innerMethod();
		
		
		
		
	}
	
	
}
