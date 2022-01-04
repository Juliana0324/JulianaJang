package day0104;

/**
 * 다중 for문
 * for(초기값: 조건식; 증감소식){ <br>
 * 	for(초기값: 조건식; 증감소식){ <br>
 * 		반복 수행 문장<br>
 * 	}<br>
 * }
 * 
 * @author user
 */
public class UseFor2 {
	public static void main(String[] args) {
		
		// 출력결과:
		 /* 0 0
			0 1
			0 2
			1 0
			1 1
			1 2
		for(int i=0; i<2;i++) {
			for(int j=0; j<3; j++) {
				System.out.println(i +" "+ j);
			}//end for
		}//end for
		
		System.out.println();

		  */
		for(int i=0; i<5;i++) {
			for(int j=0; j<6; j++) {
				System.out.println("i = "+ i +", j = "+ j);
			}//end for
			System.out.println("---------------------");
		}//end for
		
		System.out.println();
		
		/////////////////////////////////////////////////
		// 구구단 (2단 -9단, 각 단에서 1부터 9까지 반복)
		// 행으로 정렬
		for(int i=2; i<10;i++) {
			System.out.print(i+"단: ");
			for(int j=1;j<10; j++) {
				System.out.print(i+" * "+j+" = "+i*j+"\t");
			}//end for
			System.out.println();
		}//end for
		System.out.println("----------------------------------------");
		
		
		//열로 정렬
		for(int i=1; i<10;i++) {
			for(int j=2;j<10; j++) {
				System.out.print(j+" * "+i+" = "+i*j+"\t");
			}//end for
			System.out.println();
		}//end for
		System.out.println("----------------------------------------");
		
		///////////////////////////////////////////////////////////
		/* 출력결과: 
		 *  0 1 0 2 0 3 0 4 
			1 2 1 3 1 4 
			2 3 2 4 
			3 4 
		 */
		for(int i=0; i<5; i++) {
			for(int j=1+i; j<5; j++) {
				System.out.print(i+" "+j+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------");
		
		
		/////////////////////////////////////////////////////////////////
		/*0 0
		  1 0 1 1
		  2 0 2 1 2 2
		  3 0 3 1 3 2 3 3 
		*/
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(i+" " +j+ " ");
			}
			System.out.println();
		}
		
		/////////////////////////////////////////////////////////////////
		//무한 루프(while):
		// - 코드가 실행되면 종료되지 않아야할때의 내용
		// 프로그램 => 시계, OS, 서버 
		
		
		
		
		
		
		
	}//main

}//class
