package BankApp;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		boolean run = true;
		while(run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-------------------------------------------");
			System.out.print("선택> ");
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
		System.out.println("프로그램 종료");
		
	}
	
	

	private static void createAccount() {
		System.out.println("--------------");
		System.out.println("계좌 생성");
		System.out.println("--------------");
		System.out.print("계좌번호 : ");
		String ano = sc.next();

		System.out.print("계좌주 : ");
		String owner= sc.next();
		
		System.out.print("초기금액 : ");
		int balance = sc.nextInt();
		
		Account account= new Account(ano, owner, balance); 
		
		//accountArray가 null이 되면 출력후 나가기
		for(int i=0; i<accountArray.length;i++) {
			if(accountArray[i] == null) {
				accountArray[i]= account;
				System.out.println("계좌가 생성되었습니다.");
				break;
			}
		}
		
	}
	

	private static void accountList() {
		System.out.println("--------------");
		System.out.println("계좌 목록");
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
	
	//예금
	private static void deposite() {
		System.out.println("--------------");
		System.out.println(" 예 금 ");
		System.out.println("--------------");
		System.out.print("계좌번호 :");
		String checkAno = sc.next();
		
		

		for(int i=0; i<accountArray.length; i++) {
			
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(checkAno)) {
					System.out.print("예금액 :");
					int deposit = sc.nextInt();
					accountArray[i].setBalance(accountArray[i].getBalance()+deposit);
					System.out.println("예금이 성공되었습니다.");
				
				}else {
					System.out.println("계좌가 없습니다.");
				}
			}
		}
		
	}
	
	
	//출금
	private static void withdraw() {
		System.out.println("--------------");
		System.out.println(" 출 금 ");
		System.out.println("--------------");
		System.out.print("계좌번호 :");
		String checkAno = sc.next();
		
		for(int i=0; i<accountArray.length; i++) {
			
			if(accountArray[i] != null) {
				if(accountArray[i].getAno().equals(checkAno)) {
					System.out.print("출금액 :");
					int withdraw = sc.nextInt();
					
					//출금액이 기존 계좌보다 많을 시
					if(withdraw<= accountArray[i].getBalance()) {
						accountArray[i].setBalance(accountArray[i].getBalance()-withdraw);
						System.out.println("출금이 성공되었습니다.");						
					}else {
						System.out.println("잔액이 부족합니다.");
					}
					
				}else {
					System.out.println("계좌가 없습니다.");
				}
			}
		}
	}


}
