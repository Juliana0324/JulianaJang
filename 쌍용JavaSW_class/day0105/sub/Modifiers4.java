package day0105.sub;

import day0105.Modifiers;

/**
 * �ٸ���Ű�� �ڽ�Ŭ����
 * 
 * @author user
 *
 */
public class Modifiers4 extends Modifiers{
	
	public static void main(String[] args) {
		System.out.println("�ٸ� ��Ű���� �ڽ�Ŭ����");
		
		//��Ӱ��迡���� �ڽ�Ŭ������ ��üȭ�� �մϴ�.
		Modifiers4 modi = new Modifiers4();
		//������ ���� �����ڿ����� ���� ���Ұ��� ������
		
		
		modi.instanceA = 10;
		modi.instanceB = 20;
//		modi.instanceC = 30; ���x
//		modi.instanceD = 40; ���x
		System.out.println("public:"+ modi.instanceA);
		System.out.println("protected:"+ modi.instanceB);
//		System.out.println("default:"+ modi.instanceC); ���x
//		System.out.println("private:"+ modi.instanceD); ���x
		
		
	}

}
