package day0105;

/**
 * ������Ű���� �ٸ�Ŭ����
 * 
 * @author user
 *
 */
public class Modifiers2 {
	
	public static void main(String[] args) {
		System.out.println("���� ��Ű���� �ٸ� Ŭ����");
		Modifiers modi = new Modifiers();
		//������ ���� �����ڿ����� ���� ���Ұ��� ������
		
		modi.instanceA = 10;
		modi.instanceB = 20;
		modi.instanceC = 30;
		//modi.instanceD = 40; ���Ұ�
		System.out.println("public:"+ modi.instanceA);
		System.out.println("protected:"+ modi.instanceB);
		System.out.println("default:"+ modi.instanceC);
		//System.out.println("private:"+ modi.instanceD); ���x
		
		
	}

}
