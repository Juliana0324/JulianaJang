package day0103;

import java.util.Scanner;

/**
 * Switch~case ���
 * 
 * @author user
 */
public class UseSwitchCase {
	
	public static void main(String[] args) {
		//������ ����
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		switch(i) {
		case 0 :
			System.out.println("0�� ���");
			break;
		case 1 :
			System.out.println("1�� ���");
			break;
		case 2 :
			System.out.println("2�� ���");
			break;
		case 3 :
			System.out.println("3�� ���");
			break;
		default:
			System.out.println("����� ���� ���");
		
		}//end switch
		
		
		char j = 'A'; //byte, short, int, long, char
		//switch�� ������� �ԷµǴ� ������ ���������� ���
		switch(j) {
		case 'A':
			System.out.println("���� : ascii = "+(int)j);
		}
		
		
		String str = "������"; //byte, short, int, long, char
		//switch�� ������� �ԷµǴ� ������ ���������� ���
		switch(str) {
		case "������":
			System.out.println("jdk 1.7���ʹ� ���ڿ� �񱳰��� "+str);
		}//
		
		
		///////////////////////break ���/////////////////////////////
		
		
		
		
		
	}

}
