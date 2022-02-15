package day0104;

/**
 * 반복문 (loopStatement)
 * 시작과 끝을 알때 사용하는 반복문 for문
 * 단일 for문
 * @author user
 */
public class UseFor {

	public static void main(String[] args) {

		for(int i=0; i<10;i++) {
			System.out.print("안녕하세요?"+i);
		}
		System.out.println();
		////////////////////////////////////////////////////////////////
		
		
		// 1-10까지 1씩 증가하는 값 구하기
		for(int i=1; i<=10;i++) {
			System.out.print(i+"\t");
		}//end for\
		System.out.println();
		
		/////////////////////////////////////////////
		
		//1-100까지 수중에 2의배수 출력
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
				}
			}
		System.out.println();
		
		for(int i=1; i<=100; i++) {
			++i;
			System.out.print(i+" ");
		}
		System.out.println();
		
		///////////////////////////////////////////
		// 1에서부터 100까지 홀수만 출력
		for(int i=1; i<=100; i++) {
			i++;
			System.out.print(i+" ");
		}
		System.out.println();

		
		for(int i=1; i<100; i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//////////////////////////////////////////////////////
		//1에서부터 9까지 1씩 증가하여 출력하는 코드를 작성
		//출력: 위에서 아래로 (열)
		for(int i=1; i<10; i++) {
			System.out.println("2 * "+ i+" = "+(2*i));
		}
		
		
		
		////////////////////////////////////////////////////////
		//1에서부터 100까지의 합을 출력
		int sum =0;
		for(int i=1; i<101; i++) {
			sum +=i;
			
		}
		System.out.println(sum);
		
		//////////////////////////////////////////////////////
		// 10~1까지 1씩 감소하는 반복문
		for(int i=10; i>0; i--) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//무한반복문 빠지면 ctrl+alt+del
		
		
		
	}//main
}// class
