package day0104.work;

/* 2. 점수를 입력받아 입력받은 점수가 0~100사이일때 
 	40점 미만: 과락
   60점 미만 : 다른점수 참조
   100점 이하 : 성공
   0~100사이 아니면 유효점수 아닙니다 */

 public class Work2 {

	public static void main(String[] args) {
	 int score = 0;
	 score = Integer.parseInt(args[0]);
	 
	 if(score>-1 && score<101){
		 if(score<40) {
			 System.out.println("과락");
		 } else if(score<60) {
			 System.out.println("다른점수 참조");
		 }else if(score<101) {
			 System.out.println("합격");
		 }
		 
		 
	 }else{
		 System.out.println("유효점수 아님");
		 
	 }//end else
	 	
	}//main

}//class
