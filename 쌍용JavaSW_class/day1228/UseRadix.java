class UseRadix {
	public static void main(String[] args) {
	
	int decimal = 10;  //10진수
	int octal = 012;   //8진수
	int hex = 0xA;	   //16진수 0xA 16진수는 대소문자 모두 사용가능
	
	//다양한 진수를 사용하더라도 출력은 10진수로 됨
	System.out.println("10진수 : "+decimal);
	System.out.println("8진수 : "+octal);
	System.out.println("16진수 : "+hex);
	
	//서로 다른 진수를 사용하더라도 연산을 사용
	System.out.println("10진수 + 8진수 + 16진수 = "+(decimal+octal+hex));
	
	//10진수에서 2진수로
	//25 : 0001 1001
	//80 : 0101 0000
	//300 : 0000 0001 0010 1100 //쓰실때엔 Byte기준으로 쓰시면 되요
	

	//8진수에서 2진수로
	//030 : 011 000 -> 0001 1000 -> 10진수: 24
	//012 : 001 010 -> 0000 1010 -> 10진수 : 10
	//0256 : 010 101 100 -> 1010 1100 -> 10진수 : 174

	//16진수에서 2진수로 
	//0x1b : 0001 1011 -> 27
	//0xff : 1111 1111 -> 255
	
	//연산자 대상체 : 변수, 상수

	
	}
}
