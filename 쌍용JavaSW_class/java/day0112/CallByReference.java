package day0112;

/**
 * method의 매개변수가 참조형 데이터형을 ㅗ선언되어있다면, 주소가 전달된다
 * 입략받은 객체의 값을 변경하면 원본객체의 값이 변경됨
 * @author user
 *
 */
public class CallByReference {
	
	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {
		int temp = 0;
		temp = cbr.i;
		cbr.i = cbr.j;
		cbr.j = temp;
		System.out.printf("swap method 안 : i = %d, j = %d\n",cbr.i, cbr.j);
	}
	

	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
		cbr.i = 100;
		cbr.j = 300;
		
		System.out.printf("swap 호출 전: i = %d, j = %d\n",cbr.i, cbr.j);
		cbr.swap(cbr); //입력된 객체의 값이 method안에서 변경되면 하나의 주소를 사용하기 떄문에
		System.out.printf("swap 호출 후: i = %d, j = %d\n",cbr.i, cbr.j); //결과값이 변경됨
		
	}

}
