package day0105;

/**
 * ��������� ����������
 * 
 * @author user
 *
 */
public class Modifiers {
	public int instanceA; //��Ű�� ���x
	protected int instanceB; //���� ��Ű���� Ŭ�������� ���ٰ���
							// ��Ű���� �ٸ��� ��Ӱ����� �ڽ�Ŭ���������� ���ٰ���
	int instanceC;			// ���� ��Ű���� Ŭ�������� ���ٰ���
	private int instanceD; // Ŭ�����ȿ����� ���ٰ���
	
	
	public static void main(String[] args) {
		Modifiers modi = new Modifiers();
		//������ ���� Ŭ�����ȿ����� ���������ڿ� ������� ��밡��
		
		modi.instanceA = 10;
		modi.instanceB = 20;
		modi.instanceC = 30;
		modi.instanceD = 40;
		System.out.println("public:"+ modi.instanceA);
		System.out.println("protected:"+ modi.instanceB);
		System.out.println("default:"+ modi.instanceC);
		System.out.println("private:"+ modi.instanceD);
		
		
	}

}
