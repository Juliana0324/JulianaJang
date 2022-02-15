package day0104.work;

import java.util.Scanner;

public class Test2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //전체 반복할 수
		
		for(int i=0; i<T;i++) {
			String S = sc.next(); //문자
			int R = sc.nextInt(); //각 글반복할 문자의 개수

			for(int j=0;j<S.length(); j++) {
				for(int k=0; k<R; k++) {
					System.out.print(S.charAt(j));		
				}
			}
			
		}
		
		
	}

}
