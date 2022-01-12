package day0111;

public class UseArray2 {
	
	//생성자
	public UseArray2() {
		int[] stuScore = {89,77,91,99,63,100,86};
		int sum = 0;
		for(int i=0; i<stuScore.length;i++) {
			System.out.printf("%d번 : %d점 = %s학점\n", i+1, stuScore[i],gradeText(stuScore[i]));
			sum+= stuScore[i];
		}//end for

		System.out.println("총점: "+sum);
		//배열의 값중에 최고점수와 최저를 구하시오
//		scoreValidate(stuScore); 

		System.out.println("최고점수 : "+topScore(stuScore));
		
		//char형으로 배열을 만들고 배열명을 출력하면 다른배열과 다르게 값을 출력됨
		System.out.println(stuScore); //주소
		
		char[] arr = {'A','b','c','D','e'};
		System.out.println(arr);
		
		for(char value: arr) {
			System.out.print(value+" ");
		}
		
		
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
	
	public int topScore(int[] score) {
		int max=score[0];
		for(int i: score) {
			if(i>max) {
				max = i;
			} 
		}		
		
		return max;
	}
	
	
	//최고점수 
	public void scoreValidate(int[] score) {
		System.out.println("학생 7명의 점수를 처리하는 프로그램 작성");
		int max=score[0];
		int min=score[0];
		for(int i=1;i<score.length;i++) {
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

	}//main

}//class
