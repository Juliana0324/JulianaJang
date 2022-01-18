package day0118;

/**
 * ��øŬ����(nested class)
 * @author user
 *
 */
public class NestedOuter {
	int outI;
	static int outJ;
	
	
	public void outInstanceMethod() {
		System.out.println("�ٱ�Ŭ���� �޼ҵ�");
	}//out Instance method
	
	public static void outStaticMethod() {
		System.out.println("�ٱ�Ŭ���� static�޼ҵ�");
	}//out staticmethod
	
	/////////////////////nested class ����/////////////////
	static class NestedInner{
		static int inJ;
		
// ��øŬ���������� instance������ �޼ҵ带 ������ x
//		int intI; //�ν��Ͻ����� 

//		public void innerInstanceMethod() {
//			System.out.println("�̳�Ŭ���� �޼ҵ�");
//		}//out Instance method
		
		public static void inStaticMethod() {
			System.out.println("��øŬ���� static�޼ҵ�");
			
			//�ν��Ͻ� ������ �żҵ�� ���Ұ�
			//outI = 100;

		}//out staticmethod
		
		
	}
	
	/////////////////////nested class ��/////////////////

	public static void main(String[] args) {
		//��øŬ������ static�� �ַ� ������� �ʱ⋚���� ��ü�� �������� x
		NestedInner.inJ = 100;
		NestedInner.inStaticMethod();
		
	}
}
