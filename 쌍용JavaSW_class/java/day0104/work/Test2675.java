package day0104.work;

import java.util.Scanner;

public class Test2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //��ü �ݺ��� ��
		
		for(int i=0; i<T;i++) {
			String S = sc.next(); //����
			int R = sc.nextInt(); //�� �۹ݺ��� ������ ����

			for(int j=0;j<S.length(); j++) {
				for(int k=0; k<R; k++) {
					System.out.print(S.charAt(j));		
				}
			}
			
		}
		
		
	}

}
