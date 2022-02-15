class DataType 
{
	public static void main(String[] args) 
	{
		/*DataType: 값을 저장하기 위해 부여하여 언어에서 미리 예약해둔 공간
		Primitive type (기본형)
*/
		byte a = -128;
		//byte b = 128; // 제어불가
		byte b = 127;
		System.out.println("a:"+ a);
		System.out.println("b:"+ b);

		//상수 값이 메모리에 저장 되는데 그저장공간을 literal이라고 함
		//평생 벌고싶은 돈의 액수를 저장하여 출력하는 코드를 작성
		long money = 5000000000L;
		int tenYears = 120;
		
		System.out.println(money /tenYears);
			
		/*상수 형명시 
		literal의 크기를 일시적으로 변경하는 것
		상수에서만 사용할 수 있음
		
		정수 상수: 4byte의 리터럴이 8byte의 리터럴로 변경
		상수L; 혹은 상수l;

		실수 상수: 8byte의 리터럴을 4byte의 리터럴로 변경
		Float : f, F
		Double : D, d (생략)
		8byte(3.14)의 크기를 가진 값이 4byte(f)의 크기를 가진곳에서 할당될수 없다
	*/
	float f = 3.14f;
	System.out.print(f);

	}
}
