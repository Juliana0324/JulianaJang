package day0105;

/**
 * Continue문 
 * 
 * 
 * @author user
 *
 */
public class UseContinue {

	public static void main(String[] args) {
		for(int i=0; i<101; i++) {
//			System.out.println("필수 반복");
			if(i%2==1) {
				continue;
			}
			System.out.print(i+" ");
		}
		System.out.println();

				
	}

}
