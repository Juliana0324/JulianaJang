package day0121;

import java.util.Random;

/**
 * ���� Ŭ������ ���
 * 
 * @author user
 *
 */
public class UseRandom {
	public UseRandom() {
		Random ran =new Random(new Random().nextLong());
		
		int r1 = ran.nextInt();
		System.out.println("�߻��� ������ ���� "+r1);
		System.out.println("�߻��� ������ ���� "+r1%10); //ū�� % ������

		System.out.println("�߻��� ������ ���� �� ���"+Math.abs(r1%10)); //ū�� % ������
		// ==> �ξ� �����ϰ�
		int r2 = ran.nextInt(10);
		System.out.println("�߻��� ������ ���� �� ���"+r2);
		
		
		float rf = ran.nextFloat();
		double rd = ran.nextDouble();
		System.out.println(rf);
		System.out.println((int)(rd*10));
	}

	public static void main(String[] args) {
		new UseRandom();
	}

}
