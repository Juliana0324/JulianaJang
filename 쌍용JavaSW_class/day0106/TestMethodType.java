package day0106;

/**
 * method�� 4���� ����
 *
 */
public class TestMethodType {
	/**
	 * 1. ������: ��ȯ��x �Ű����� ���� ��
	 */
	public void typeA() {
		System.out.println("������: ȣ���� �ϴ��� �׻� ���� ���� �����Ѵ�");
	}	
	
	/**2. ������ : ��ȯ��x �Ű����� �ִ� ��
	 * 	 �ԷµǴ� ������ ������ �� ���డ��
	 * @param i
	 */
	
	public void typeB(int i) {
		System.out.println(i+"��/�� ȣ��");
		
	}

	/**
	 * 3. ������: ��ȯ��o �Ű����� ���� ��
	 * @return
	 */
	public int typeC() {
		int i=2022;
		return i;
	}

	/**
	 * 
	 * 4. ������: ��ȯ��o �Ű����� �ִ� �� 
	 * �Ű������� ���� ȣ������ �� �ٸ� �� ��ȯ
	 */
	public int typeD(double n) {
		return (int)n;
	}
	
	//////////////////////////////////////////
	public static void main(String[] args) {
		TestMethodType tmt = new TestMethodType();
		tmt.typeA();
		tmt.typeB(10);
		System.out.println("������: "+tmt.typeC());
		
		int value1 = tmt.typeC();
		System.out.println("������: "+value1);
		
		System.out.println("������: "+tmt.typeD(10.4));
		int value2 = tmt.typeD(22.106);
		System.out.println("������: "+value2);
	}

}
