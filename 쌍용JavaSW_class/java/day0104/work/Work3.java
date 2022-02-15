package day0104.work;

import java.util.Scanner;

/**
 * 	 �⺻��� 
		��������: 800 
		���� : 1250
		����ö: 1300
		
		�⺻����� 10km���� ��ȿ, 10km�ʰ��� �� 5km���� �߰���� 100���� �߰�
		��°�� : �Է±������ "XX" �̵��Ÿ�:XXkm �⺻��� : XX�� �ʰ���� XX�� 
				�Ѵ�20�� ���� ����� xx�� 
				
				* ���߱��� ������ �ƴҰ�� "���߱����� �ƴմϴ� ���"
 *
 */

public class Work3 {
	public static final int TBUS = 800;
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String transport = sc.next();
		if(transport.equals("��������")||transport.equals("����")||transport.equals("����ö")) {
			int km = sc.nextInt();
			int overFee = 0;
			int fare = 0;

			if(transport.equals("��������")) {
				fare =Work3.TBUS;
			} else if(transport.equals("����")){
				fare =Work3.BUS;
			//����ö
			} else{
				fare =Work3.SUBWAY;
			}//end else
			
			if(km > 10) {
				//�ʰ���� ���
				overFee = (((km -10)/5)+1)*100;
			}//end if
			
			System.out.println("�Է±������ "+transport+" �̵��Ÿ� "+km+ "km, �⺻���"
					+ fare+"��, �� ��� "+(fare+overFee)+"�� �Ѵ� ����� "+(fare+overFee)*2*20+"��");
			
			
		} else{
			System.out.println(transport+"���߱����� �ƴմϴ�.");
		}
		
		
		
	
	 	
	}//main

}//class
