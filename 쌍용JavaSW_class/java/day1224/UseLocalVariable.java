/*
	지역변수의 사용
*/
class UseLocalVariable {
	//Java Application
	public static void main(String[] args) 
	{
		//1. 변수선언
		int i;
		int age = 25;
		System.out.println(age);

		age = 27;
		System.out.println(age);
		

/*		데이터 형이 달라도 변수명이 같다면 에러
		double age = 200;
		System.out.println(age);

*/		
		int bornYear=sc.nextInt();
		int thisYear = 2021;
				
		int result = thisYear - bornYear + 1;
		System.out.println(result);

	}
}
