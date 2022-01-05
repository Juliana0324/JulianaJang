package day0105;

/**
 * do while사용
 * 최소 1번 수행, 최대조건까지 수행
 * 
 *   */
public class UseDoWhile {

	public static void main(String[] args) {
		int i=1000; //초기값
		//무조건 1번실행
		do {
			System.out.println(i);
			i++;
		} while(i<10);
		////////////////////////////
		int j=2;
		i=Integer.parseInt(args[0]);
		do {
			if(i<10) {
				System.out.print(i+" * "+j +" = "+i*j+"\t");
				j++;				
			}else {
				System.out.println("2-10단 이내 입력");
				break;
			}
		}while(j<10);
		
		
		
	}

}
