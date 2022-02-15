package day0104.work;

import java.util.Scanner;

/**
 * 	 기본요금 
		마을버스: 800 
		버스 : 1250
		지하철: 1300
		
		기본요금은 10km까지 유효, 10km초과시 매 5km마다 추가요금 100원씩 추가
		출력결과 : 입력교통수단 "XX" 이동거리:XXkm 기본요금 : XX원 초과요금 XX원 
				한달20일 기준 교통비 xx원 
				
				* 대중교통 수단이 아닐경우 "대중교통이 아닙니다 출력"
 *
 */

public class Work3 {
	public static final int TBUS = 800;
	public static final int BUS = 1250;
	public static final int SUBWAY = 1300;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String transport = sc.next();
		if(transport.equals("마을버스")||transport.equals("버스")||transport.equals("지하철")) {
			int km = sc.nextInt();
			int overFee = 0;
			int fare = 0;

			if(transport.equals("마을버스")) {
				fare =Work3.TBUS;
			} else if(transport.equals("버스")){
				fare =Work3.BUS;
			//지하철
			} else{
				fare =Work3.SUBWAY;
			}//end else
			
			if(km > 10) {
				//초과요금 계산
				overFee = (((km -10)/5)+1)*100;
			}//end if
			
			System.out.println("입력교통수단 "+transport+" 이동거리 "+km+ "km, 기본요금"
					+ fare+"원, 총 요금 "+(fare+overFee)+"원 한달 교통비 "+(fare+overFee)*2*20+"원");
			
			
		} else{
			System.out.println(transport+"대중교통이 아닙니다.");
		}
		
		
		
	
	 	
	}//main

}//class
