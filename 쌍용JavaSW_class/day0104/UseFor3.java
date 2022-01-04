package day0104;

/**
 * for(초기값; 조건문; 증감소값){
 * 	실행문장
 * }
 * @author user
 */
public class UseFor3 {
	public static void main(String[] args) {
		/*
		 * for(;;) { System.out.println("무한루프"); break; //한번 실행하고 나감 -> 가장 가까운 반복문을 빠져나감
		 * }
		 */
		
		//증가하는 수를 세는 무한루프
		/*
		 * for(int i=0; ;i++) { System.out.println("무한루프 = "+i); //무한 루프 }
		 *///		System.out.println("안녕"); //여기까지 도달하지 않음

		
		//중간 조건문은 한개만 작성 가능
		// => i<10 , j>100 .. 이런식으로 사용불가
		for(int i=0,j=10,k=1; i<10; i++,j--,k+=k) {
			System.out.println("i = "+i+", j = "+j+ ", k = "+k);
		}
		
		/* 결과
			i = 0, j = 10, k = 100
			i = 1, j = 9, k = 101
			i = 2, j = 8, k = 102
			i = 3, j = 7, k = 103
			i = 4, j = 6, k = 104
			i = 5, j = 5, k = 105
			i = 6, j = 4, k = 106
			i = 7, j = 3, k = 107
			i = 8, j = 2, k = 108
			i = 9, j = 1, k = 109

		 */
		
		
		//improvement for() - for each문
		int[] arr = {1,2,3,4,5};
		for(int i: arr) {
			System.out.println(i);
		}
		//기존의 index를 사용하는 for와는 다르게 collection의 
		//값을 얻어 적은 코드로 출력하기 위해 사용
		
		
	}//main

}//class
