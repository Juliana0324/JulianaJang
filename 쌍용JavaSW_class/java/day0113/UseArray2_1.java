package day0113;

import javax.swing.text.html.HTML;

/**
 * 이차원 배열의 기본형 형식의 사용
 * @author user
 */
/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
/**
 * @author user
 *
 */
public class UseArray2_1 {
	public static final int JAVA_IDX =0;
	public static final int ORACLE_IDX =0;
	public static final int HTML_IDX =0;
	
	private int javaTotal, oracleTotal, htmlTotal;
	private int JavaTopScore;
	
	public void scoreProcess() {
		String[] names= {"강명준","권용현","김정하","김현우","김진영"};
		int[][] score= {
				{90,94,91},{86,84,71},{96,99,100},{75,76,73},{63,69,69}
				};		
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("번호\t이름\t자바\t오라클\tHTML\t총점\t평균");
		System.out.println("---------------------------------------------------------------------------------");
		
		int totalScore=0;// 학생 총점 
		for( int i = 0 ; i < score.length ; i++) {//행
			System.out.printf("%d\t%s\t",i+1, names[i]);
			for(int j = 0 ; j < score[i].length ; j++) {//열
				System.out.printf("%d\t", score[i][j]);
				totalScore+=score[i][j];//한 학생의 점수를 누적 합(+=) 
			}//end for
			System.out.printf("%d\t%.2f\n",totalScore, (double)totalScore/score[0].length);
			totalScore=0;
		}//end for
		System.out.println("---------------------------------------------------------------------------------");
		 System.out.printf("응시인원 [ %d ]명\n",score.length);
		 //숙제. 코드를 직접기술해서 처리.
		 System.out.printf("전체 총점 [ %d ]점,전체 평균[%.2f]\n",0, 0.0);
		 //숙제. 아래의 작업을 instance variable과 method를 작성하여 처리 결과를 출력.  
		 
		 
		 
		 System.out.printf("자바 총점 [ %d ]점, 오라클 총점[ %d ], HTML 총점[ %d ]\n",JAVA_IDX, ORACLE_IDX, HTML_IDX);
		 System.out.printf("자바 최고점수 [ %d ]점\n",0);
		 System.out.printf("1등학생의 번호[ %d], 이름[%s ]\n",0,"");
	}//useArray2
	
	
	/**
	 * 과목 총점
	 */
	public void subjectTotal(int[][] score) {
		//score배열
		for(int i=0; i<score.length; i++) {
			javaTotal += score[i][0];
			oracleTotal+= score[i][1];
			htmlTotal += score[i][2];
		}
		System.out.printf("자바 총점 [ %d ]점, 오라클 총점[ %d ], HTML 총점[ %d ]\n",javaTotal, oracleTotal,htmlTotal);
	}

	public int eachScore(int[][] score, int num) {
		int eachScore = 0;
		for(int i=0; i<score.length; i++) {
				eachScore += score[i][num];		
		}//end for
		
		return eachScore;
	}//eachScore
	
	
	
	public static void main(String[] args) {
		new UseArray2_1().scoreProcess();
	}//main

}//class
