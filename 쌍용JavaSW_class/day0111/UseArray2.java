package day0111;

public class UseArray2 {
	
	//생성자
	public UseArray2() {
		int[] stuScore = {89,77,91,99,63,100,86};
		int sum = 0, max =0;
		int min = stuScore[0];
		for(int i=0; i<stuScore.length;i++) {
			System.out.printf("%d번 : %d점 = %s학점\n", i+1, stuScore[i],gradeText(stuScore[i]));
			sum+= stuScore[i];
		}//end for

		System.out.println("총점: "+sum);
		//배열의 값중에 최고점수와 최저를 구하시오
		scoreValidate(stuScore);
		
		
//		if(stuScore[i]>max) {
//			max = stuScore[i];
//		}else if(stuScore[i]<min){
//			min = stuScore[i];
//		}//end if		
//		System.out.println("최고점수 : "+max);
//		System.out.println("최저점수 : "+min);
		
		
	}//UseArray2

	public String gradeText(int score) {
		String s = "F";
		if(score<=100 && score>89) {
			s = "A";
		} else if(score<90 && score>79){
			s= "B";
		} else if(score<80 && score>69){
			s= "C";
		} else if(score<70 && score>59){
			s= "D";
		}
		
		return s;
		
	}
	
	
	
	
	//최고점수 
	public void scoreValidate(int[] score) {
		System.out.println("학생 7명의 점수를 처리하는 프로그램 작성");
		int max=0;
		int min=score[0];
		for(int i=0;i<score.length;i++) {
			if(score[i]>max) {
				max = score[i];
			} else if(score[i]<min) {
				min = score[i];
			}
		}		
		System.out.println("최고점수 :"+max);
		System.out.println("최소점수 :"+min);
		
	}

	public static void main(String[] args) {
		//UseArray2 ua = new UseArray2();
		new UseArray2();
		System.out.println();
		//new UseArray2().scoreValidate();

	}//main

}//class
