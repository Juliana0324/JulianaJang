package day0105.sub;

import day0105.Modifiers;

/**
 * �ٸ���Ű���� �ٸ�Ŭ����
 * 
 * @author user
 *
 */
public class Modifiers3 {
	
	public static void main(String[] args) {
		System.out.println("�ٸ� ��Ű���� �ٸ� Ŭ����");
		
		Modifiers modi = new Modifiers();
		//������ ���� �����ڿ����� ���� ���Ұ��� ������
		
		modi.instanceA = 10;
		//modi.instanceB = 20;���x
		//modi.instanceC = 30;���x
		//modi.instanceD = 40; ���Ұ�
		System.out.println("public:"+ modi.instanceA);
		//System.out.println("protected:"+ modi.instanceB); ���x
		//System.out.println("default:"+ modi.instanceC); ���x
		//System.out.println("private:"+ modi.instanceD); ���x
		
		
	}

}
