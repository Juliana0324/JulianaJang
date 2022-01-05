package day0105;

/**
 * While문 (시작과 끝을 모를떄 사용하는 반복문)
 * 최소 0번 수향 최대조건까지 수행
 * 
 * @author user
 */
public class UseWhile {

	public static void main(String[] args) {
		int i=1;
		while(i<101) {
			i++;
			System.out.print(i + " ");
		}//end while
		
		System.out.println();
		System.out.println("-----------------------------------------------");
		/////////////////////////////
		//1-100까지 3의배수만 출력
		int j=1;
		while(j<101) {
			j++;
			if(j%3==0) {
				System.out.print(j+" ");
			}//end if
		}//end while
	
		System.out.println();
		System.out.println("-----------------------------------------------");
		//////////////////////////////////////
		//while을 사용하여 구구단 9단 출력
		i = 2;
		while(i<10) {
			System.out.print("9 * "+i+" = "+9*i+"\t");
			i++;
		}
		
		
		
		
		
	}

}
