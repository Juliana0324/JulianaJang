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
		//1. ��𿡼��� ȣ��, �¾���Է¹޾� ���� ����Ͽ� ����ϴ� method �ۼ�
		Homework hm = new Homework();
		hm.BirthYear(1997);
		
		// 2. ������ �Է¹޾Ƽ� �빮��, �ҹ���, ���ڿ� �ش��ϴ� ������� �ش繮�ڷ� ��� 
		// �׷��� �ʴٸ� �Էµ� ���ڸ� ����ϴ� method �ۼ�
		//	Ȯ���۾�
		//	for(int i=47;i<125; i++) {
		//		hm.Num(i);
		//	}
		
		hm.Num(122);

		

	}

}
