package day0119;

import java.util.ArrayList;
import java.util.List;

/**
 * Math => private에 생성자가 없기떄문에 
 * instance메소드가 없음
 * Static 메소드밖에 없음
 * @author user
 *
 */
public class UseMath {

	
	public static void main(String[] args) {

		System.out.println(Math.max(10, 200));
		System.out.println(Math.abs(-10));//절대값
		System.out.println(Math.round(10.3));//반올림
		System.out.println(Math.ceil(10.5));//올림
		System.out.println(Math.floor(10.5));//내림
		System.out.println(Math.sqrt(4)); //제곱근

		double num = Math.random();
		System.out.println("발생한 난수 "+num);
		System.out.println("범위의 난수 "+(int)((num*9)+1));
		
		//1-100사이의 난수
		int temp = (int)(Math.random()*100)+1;
		System.out.println("1-100까지 난수 "+temp);
		
		int alp = (int)(Math.random()*26)+65;
		System.out.println((char)alp);
		
		int lower = (int)(Math.random()*26)+97;
		System.out.println((char)lower);
		
		int cal = (int)(Math.random()*10)+48;
		System.out.println((char)cal);
		//잘하셨습니다.
		
		
		System.out.println("========================");
		//중복되지 않는 난수 구하기
		
		int[] randomList = new int[6];
		for(int i=0; i<6; i++) {
			randomList[i] = (int)(Math.random()*45);
			
			for(int j=0; j<i;j++) {
				if(randomList[i] == randomList[j]) {
					i--;
					break;
				}
			}
			
			
		}
		
		for(int i: randomList) {
			System.out.print(i+" ");
		}
		

	}

}
