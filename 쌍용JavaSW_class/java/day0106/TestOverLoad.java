package day0106;

/**
 * method�� overload. ���� ���� method�� ���
 * �Ű������� �ٸ���
 * @author user
 *
 */
public class TestOverLoad {
	
	/**
	 * ���� �ϳ� ����ϴ� ��
	 */
	public void printstar() {
		System.out.print("�� ");
	}
	
	/**
	 * �Էµ� ����� �� ���
	 * @param a
	 */
	public void printstar(int a) {
		for(int i=0;i<a;i++) {
			System.out.print("�� ");
		}

	}
	
	public static void main(String[] args) {
		TestOverLoad tol = new TestOverLoad();
		tol.printstar();
		System.out.println();
		
		tol.printstar(5);
		
		
	}

}
