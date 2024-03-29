class Homework {
	public static void main(String[] args) {
		// 1. 태어난 해를 입력받아 띠를 출력하는 코드를 작성
		// 0-원숭이, 1- 닭, 2-개, 3- 돼지, 4-쥐 5-소, 6-호랑이, 7-토끼, 8-용, 9-뱀, 10-말, 11-양
		// 출력결과 : 199*년 생은 *띠 입니다
		int year = Integer.parseInt(args[0]);
		int zodiac = year%12;
		if(zodiac==0){
			System.out.println(year+"년생은 원숭이 띠입니다.");
		}else if(zodiac == 1){
			System.out.println(year+"년생은 닭 띠입니다.");
		}else if(zodiac == 2){
			System.out.println(year+"년생은 개 띠입니다.");
		}else if(zodiac == 3){
			System.out.println(year+"년생은 돼지 띠입니다.");
		}else if(zodiac == 4){
			System.out.println(year+"년생은 쥐 띠입니다.");
		}else if(zodiac == 5){
			System.out.println(year+"년생은 소 띠입니다.");
		}else if(zodiac == 6){
			System.out.println(year+"년생은 호랑이 띠입니다.");
		}else if(zodiac == 7){
			System.out.println(year+"년생은 토끼 띠입니다.");
		}else if(zodiac == 8){
			System.out.println(year+"년생은 용 띠입니다.");
		}else if(zodiac == 9){
			System.out.println(year+"년생은 뱀 띠입니다.");
		}else if(zodiac == 10){
			System.out.println(year+"년생은 말 띠입니다.");
		}else {
			System.out.println(year+"년생은 양 띠입니다.");
		}


///////////////////////////////////////////////////////////////////////////////
		// 2. 점수를 입력받아 입력받은 점수가 0~100사이일때 
		/* 40점 미만: 과락
		   60점 미만 : 다른점수 참조
		   100점 이하 : 성공
		   0~100사이 아니면 유효점수 아닙니다 */

		int score = Integer.parseInt(args[1]); 
		
		if (score>=0 && score<40){
			System.out.println("과락");
		
		}else if(score>39 && score <60){
			System.out.println("다른 점수 참조");
		
		}else if(score>59 && score<101){
			System.out.println("합격");			
		
		} else{
			System.out.println("유효점수가 아닙니다.");	
		}


///////////////////////////////////////////////////////////////////////////////
		//3. 대중교통 수단과 거리를 입력
		// 대중교통 수단 : 마을버스, 버스, 지하철로 한정
		
		/* 기본요금 
			마을버스: 800 
			버스 : 1250
			지하철: 1300
			
			기본요금은 10km까지 유효, 10km초과시 매 5km마다 추가요금 100원씩 추가
			출력결과 : 입력교통수단 "XX" 이동거리:XXkm 기본요금 : XX원 초과요금 XX원 
					한달20일 기준 교통비 xx원 
					
					* 대중교통 수단이 아닐경우 "대중교통이 아닙니다 출력"
		*/

		String ride = args[2];
		int km = Integer.parseInt(args[3]);
		int fee=0;
		int addFee=0;
		
		//한달 20일 평균 교통비 : 왕복요금으로 계산
		//마을버스
		if(ride.equals("마을버스")) {
			fee = 800;
			
			if(km-10 < 5){
				System.out.println("입력교통수단 :"+ride+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+addFee+"원\n"
					+"한달20일 기준 교통비 "+ fee*2*20 +"원");
			}else if((km-10) > 4){
				//추가요금 : km에서 10km 뺀값에 몫만 100곱하기
                addFee = (km-10)/5*100;
				System.out.println("입력교통수단 :"+ride+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+ addFee+"원\n"
					+"한달20일 기준 교통비 "+((fee+addFee)*2*20) +"원");
			}
		
		//버스
		} else if(ride.equals("버스")){
			fee = 1250;
			
			if(km-10 < 5){
				System.out.println("입력교통수단 :"+ride+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+addFee+"원\n"
					+"한달20일 기준 교통비 "+(fee*2)*20 +"원");
			}else if((km-10) > 4){
                addFee = (km-10)/5*100;
				
				System.out.println("입력교통수단 :"+ride+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+ addFee+"원\n"
					+"한달20일 기준 교통비 "+((fee+addFee)*2*20) +"원");
			}

		//지하철
		} else if(ride.equals("지하철")){
			fee = 1300;
			if(km-10 < 5){
				System.out.println("입력교통수단 :"+ride+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+addFee+"원\n"
					+"한달20일 기준 교통비 "+ fee*2*20 +"원");
			
			}else if((km-10) > 4){
                addFee = (km-10)/5*100;
				
				System.out.println("입력교통수단 :"+ride+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+ addFee+"원\n"
					+"한달20일 기준 교통비 "+((fee+addFee)*2*20) +"원");
			}

		//대중교통 아닐때
		}else{
			System.out.println("대중교통이 아닙니다.");
		}
		


	


	}
}
