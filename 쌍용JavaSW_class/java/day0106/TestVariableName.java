package day0106;

/**
 * ���� �̸��� ������ ��������� error
 * @author user
 *
 */
public class TestVariableName {
	/**
	 * class field : instance variable, static(class) variable
	 * class field�� ����Ǵ� ������ �̸��� �����ϴ�.
	 * 
	 */
	int i;
	static int j;
	
	public static void main(String[] args) {
		//local
		//������ class field�� ������ �ٸ��� ������ 
		// class field�� ����� �̸��� ���������� ��밡��
		int i=10;
		System.out.println(i);
		
		TestVariableName tvn = new TestVariableName();
		System.out.println(tvn.i);
		
		
		
	}//

}//
