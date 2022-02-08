package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Scanner;

public class UseScanner {
	public UseScanner() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String val = br.readLine();

		try {
			int age = Integer.parseInt(val);
			Calendar cal = Calendar.getInstance();
			System.out.println("태어난 해는 : "+(cal.get(Calendar.YEAR)-age+1));
		} catch (NumberFormatException e) {
			System.err.println("나이는 숫자입니다.");
		}
		
		
		//scanner
		Scanner sc=  new Scanner(System.in);
		int age = sc.nextInt();
		System.out.println(Calendar.getInstance().get(Calendar.YEAR)-age+1);
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			new UseScanner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
