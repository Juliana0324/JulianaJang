package day0103;

import java.util.Scanner;

/**
 * Switch~case 사용
 * 
 * @author user
 */
public class UseSwitchCase {
	
	public static void main(String[] args) {
		//변수의 선언
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		switch(i) {
		case 0 :
			System.out.println("0인 경우");
			break;
		case 1 :
			System.out.println("1인 경우");
			break;
		case 2 :
			System.out.println("2인 경우");
			break;
		case 3 :
			System.out.println("3인 경우");
			break;
		default:
			System.out.println("상수가 없는 경우");
		
		}//end switch
		
		
		char j = 'A'; //byte, short, int, long, char
		//switch의 상수에는 입력되는 변수의 범위까지만 사용
		switch(j) {
		case 'A':
			System.out.println("실행 : ascii = "+(int)j);
		}
		
		
		String str = "가나다"; //byte, short, int, long, char
		//switch의 상수에는 입력되는 변수의 범위까지만 사용
		switch(str) {
		case "가나다":
			System.out.println("jdk 1.7부터는 문자열 비교가능 "+str);
		}//
		
		
		///////////////////////break 사용/////////////////////////////
		
		
		
		
		
	}

}
