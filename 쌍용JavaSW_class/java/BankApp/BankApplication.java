package BankApp;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("-------------------------------------------");
			System.out.print("����> ");
			int selectNo = sc.nextInt();
			
			if (selectNo == 1) {
				createAccount();

			}
			else if(selectNo == 2) {
				accountList();
			}
			else if(selectNo == 3) {
				deposite();
			}
			else if(selectNo == 4) {
				withdraw();
			}
			else if(selectNo==5){
				run = false;
			}
		}
		System.out.println("���α׷� ����");
		
	}
	
	

	private static void createAccount() {
		System.out.println("--------------");
		System.out.println("���� ����");
		System.out.println("--------------");
		System.out.print("���¹�ȣ : ");
		String ano = sc.next();

		System.out.print("������ : ");
		String owner= sc.next();
		
		System.out.print("�ʱ�ݾ� : ");
		int balance = sc.nextInt();
		
		Account account= new Account(ano, owner, balance); 
		
		//accountArray�� null�� �Ǹ� ����� ������
		for(int i=0; i<accountArray.length;i++) {
			if(accountArray[i] == null) {
				accountArray[i]= account;
				System.out.println("���°� �����Ǿ����ϴ�.");
				break;
			}
		}
		
	}
	

	private static void accountList() {
		System.out.println("--------------");
		System.out.println("���� ���");
		System.out.println("--------------");
	
		for(int i=0; i<accountArray.length;i++) {
			if(accountArray[i] != null) {
				System.out.print(accountArray[i].getAno()+"\t");
				System.out.print(accountArray[i].getOwner()+"\t");
				System.out.print(accountArray[i].getBalance()+"\t");
				System.out.println();				
			}
		}
	}
	
	//����
	private static void deposite() {
		System.out.println("--------------");
		System.out.println(" �� �� ");
		System.out.println("--------------");
		System.out.print("���¹�ȣ :");
		String checkAno = sc.next();
		
		

		for(int i=0; i<accountArray.length; i++) {
			
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(checkAno)) {
					System.out.print("���ݾ� :");
					int deposit = sc.nextInt();
					accountArray[i].setBalance(accountArray[i].getBalance()+deposit);
					System.out.println("������ �����Ǿ����ϴ�.");
				
				}else {
					System.out.println("���°� �����ϴ�.");
				}
			}
		}
		
	}
	
	
	//���
	private static void withdraw() {
		System.out.println("--------------");
		System.out.println(" �� �� ");
		System.out.println("--------------");
		System.out.print("���¹�ȣ :");
		String checkAno = sc.next();
		
		for(int i=0; i<accountArray.length; i++) {
			
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(checkAno)) {
					System.out.print("��ݾ� :");
					int withdraw = sc.nextInt();
					
					//��ݾ��� ���� ���º��� ���� ��
					if(withdraw<= accountArray[i].getBalance()) {
						accountArray[i].setBalance(accountArray[i].getBalance()-withdraw);
						System.out.println("����� �����Ǿ����ϴ�.");						
					}else {
						System.out.println("�ܾ��� �����մϴ�.");
					}
					
				}else {
					System.out.println("���°� �����ϴ�.");
				}
			}
		}
	}


}
