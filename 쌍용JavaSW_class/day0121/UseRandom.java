package day0121;

import java.util.Random;

/**
 * 랜덤 클래스의 사용
 * 
 * @author user
 *
 */
public class UseRandom {
	public UseRandom() {
		Random ran =new Random(new Random().nextLong());
		
		int r1 = ran.nextInt();
		System.out.println("발생한 정수의 난수 "+r1);
		System.out.println("발생한 범위의 난수 "+r1%10); //큰수 % 범위수

		System.out.println("발생한 범위의 난수 중 양수"+Math.abs(r1%10)); //큰수 % 범위수
		// ==> 훨씬 간편하게
		int r2 = ran.nextInt(10);
		System.out.println("발생한 범위의 난수 중 양수"+r2);
		
		
		float rf = ran.nextFloat();
		double rd = ran.nextDouble();
		System.out.println(rf);
		System.out.println((int)(rd*10));
	}

	public static void main(String[] args) {
		new UseRandom();
	}

}
