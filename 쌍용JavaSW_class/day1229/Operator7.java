/*
	대입연산자 
*/
class Operator7 {
	public static void main(String[] args) {
		int i= 5;
		
		//산술연산	
		i=7;
		i+= 5;
		System.out.println("i=i+7 = "+ i);

		i = 2; //0000 0010
		i<<=3; //0001 0000
		System.out.println("i = i<<3 = "+i); //16
		
		i=15;	// 0000 1111
		i &= 6; // 0000 0110
		System.out.println("i = i & 6 = "+i);

	}
}
