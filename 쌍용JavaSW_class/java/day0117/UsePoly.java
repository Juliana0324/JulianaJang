package day0117;

public class UsePoly {

	/** 
	 * ��ü �������� ����ϱ� ���� method
	 * @param tp
	 */
	public void usePoly(TestPoly tp) {
		//tp��� ��ü�� ����ϴµ� �ٸ� ����� ��°�.
		
		tp.polymorphism();
		
	}
	
	public static void main(String[] args) {
		//��ü�� ������
		// �ԷµǴ� ��ü�� ���� �ٸ� ���� ����
		UsePoly up = new UsePoly();
		up.usePoly(new TestPoly2());
		up.usePoly(new TestPoly3());
		up.usePoly(new TestPoly());

	}//main

}
