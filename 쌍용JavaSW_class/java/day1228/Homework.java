class Homework {
	public static void main(String[] args) {
		//1. 1의 보수 연산자를 사용하여 부호를 바꾸고 값은 그대로 출력
		int i=12;
		System.out.println(i+"의 보수 : "+~(i-1));
	
		//2. 아래의 코드를 보고 어떤값이 나올지 예상해본후 코딩하여 결과를 출력
		i=10;
		int j=10;

		//예상 : 후치 i++ : 10 
		//      + 
		//      전치 :--j = 9 
		//      => 19
		System.out.println(i++ + --j);


		//3. i변수에 int가 가질수 있는 최댓값을 할당하고, 쉬프트 연산을 이용하여 15로 만들어 출력
		//15 => 1111	(63-4개)
		i = Integer.MAX_VALUE;
		System.out.println(i>>59);
	

	}
}
