/*
	다중 if
*/
class TestElseIf {
	public static void main(String[] args) {
		//점수를 입력받아 0보다 작았을때 실패메세지와 100점보다 컸을때 실패 메시지와 
		//성공했을때 메세지 출력
		/*int score = Integer.parseInt(args[0]);

		System.out.print(score+"점은 ");
		
		if(score < 0){
			System.out.println("0점 보다 작습니다.");	
		} else if(score>100){
			System.out.println("100점 보다 큽니다.");	
		} else{
			System.out.println("성공");	
		}//end else
		*/

		/////////////////////////////////////
		
		// 수를 입력받아 0~39까지는 "과락"
		// 40-59 -> "다른점수 참조"
		// 60- 100 -> "합격"
		// 
		
		int score = Integer.parseInt(args[0]); 
		
		if (score>=0 && score<40){
			System.out.println("과락");
		
		} else if(score>39 && score <60){
			System.out.println("다른 점수 참조");
		
		} else if(score>59 && score<101){
			System.out.println("합격");			
		
		}




	} //end main
} //class
