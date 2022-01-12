package day0111;

import java.util.Scanner;

public class Test1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//고정
		int A= sc.nextInt();
		//가변값
		int B = sc.nextInt();
		
		//노트북의 판매액
		int C = sc.nextInt();
		int N=0;
		
		if(C<=B) {
			N=-1;
		}else {
			N = (A/(C-B))+1;
		}
		System.out.println(N);
		
		
		
	}
	
}
