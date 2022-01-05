package day0105;

import java.util.Scanner;

public class Homework {

	public void BirthYear(int a) {
		System.out.println(2022-a+1);
	}
	
	
	public void Num(int number) {
		if(number>47&&number<58) {
			System.out.println((char)number);

		} else if(number>64 && number<91){
			System.out.println((char)number);			

		} else if(number>96 && number<123) {
			System.out.println((char)number);

		} else {
			System.out.println(number);
		}
		
		
	}
	
	public static void main(String[] args) {
		//	Scanner sc= new Scanner(System.in);
		//1. 어디에서나 호출, 태어난해입력받아 나이 언산하여 출력하는 method 작성
		Homework hm = new Homework();
		hm.BirthYear(1997);
		
		// 2. 정수를 입력받아서 대문자, 소문자, 숫자에 해당하는 범위라면 해당문자로 출력 
		// 그렇지 않다면 입력된 숫자를 출력하는 method 작성
		//	확인작업
		//	for(int i=47;i<125; i++) {
		//		hm.Num(i);
		//	}
		
		hm.Num(122);

		

	}

}
