package day0104.work;

import java.util.Scanner;

public class Test1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next().toUpperCase();
		int[] cnt = new int[26];
		
		for(int i=0; i<word.length(); i++) {
			int num = word.charAt(i) - 'A';
			cnt[num]++;
		}
		
		int max = 0;
		char answer=' ';
		for(int i=0; i<cnt.length; i++) {
			if(cnt[i]>max) {
				max = cnt[i];
				answer = (char)(i+'A');
			}
			else if(cnt[i]==max) {
				answer= '?';
			}
		}
		System.out.println(answer);
		
	}

}
