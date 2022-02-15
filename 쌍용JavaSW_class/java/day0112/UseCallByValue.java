package day0112;

/**
 * 값 복사 : method의 매개변수로 
 * @author user
 *
 */
public class UseCallByValue {	
	/**
	 * 매개변수로 선언된 i와 j의 값을 서로 바꾸는일
	 * @param i
	 * @param j
	 */
	public void swap(int i,int j) {
		int temp =0 ;
		temp = i;
		i=j;
		j = temp;
		System.out.printf("swap method 안: i = %d, j=%d\n", i, j);
	}
	
	public static void main(String[] args) {
		UseCallByValue cbv = new UseCallByValue();
		int i=100, j=300;
		System.out.printf("swap 전: i = %d, j=%d\n", i, j); //100, 300
		cbv.swap(i, j);
		System.out.printf("swap 후: i = %d, j=%d\n", i, j); //100, 300
	}

}
