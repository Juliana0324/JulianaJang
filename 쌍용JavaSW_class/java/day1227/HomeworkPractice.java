class HomeworkPractice{

	public static final int PAYMENT=20000; 
	public static final int ONEWAY=2500; 

	public static void main(String[] args)	{
		//1. 하루 용돈 ***원, 편도 차비 ***원, 왕복 차비 ***원,
		//점심 식대 ***원
		//남은 금액
		int lunch= 5000, fare= ONEWAY*2;
		int leftover = PAYMENT - (ONEWAY*2) - lunch;
		System.out.printf("하루 용돈 %d원, 편도 차비 %d원, 왕복 차비 %d원\n", PAYMENT, ONEWAY, fare);
		System.out.println("점심 값 :"+lunch+"원");
		System.out.println("남은 금액 : "+leftover+"원");
		System.out.println();
			
		//2. 양안시력 : (왼눈 + 오른눈 )/2 
		double leftEye = 0.3;
		double rightEye = 1.0;
		double bothEye = (leftEye+rightEye)/2;
		System.out.println("나의 왼쪽 눈 시력 :"+leftEye+ " 오른쪽 눈 시력 : "+rightEye);
		System.out.println("양안 시력 :"+bothEye);
		System.out.println();
		
		//3. int i=65;가 할당되어있다. 
		// i를 이용해서 대문자와 소문자를 출력하시오
		int i = 65;
		char cap = (char)i;
		char low = (char)(i+32);
		System.out.println("대문자 "+cap+"이고, 소문자 "+low);
		System.out.println();
		
		//4. API에서 wrapper class를 모두 찾아보고 아래와 같이 출력.
		//단 , MAX_VALUE와 MIN_VALUE가 존재하지 않는 Wrapper Class에 대해서는 출력하지 않는다
		System.out.println("Byte의 최소값 "+ Byte.MIN_VALUE+" 최대값 "+Byte.MAX_VALUE);
		System.out.println("Short의 최소값 "+ Short.MIN_VALUE+" 최대값 "+Short.MAX_VALUE);
		System.out.println("Integer의 최소값 "+ Integer.MIN_VALUE+" 최대값 "+Integer.MAX_VALUE);
		System.out.println("Character 최소값: "+(int)(Character.MIN_VALUE)+" 최대값 :"+(int)(Character.MAX_VALUE));
		System.out.println("Double의 최소값 "+ Double.MIN_VALUE+" 최대값 "+Double.MAX_VALUE);
		System.out.println("Float의 최소값 "+ Float.MIN_VALUE+" 최대값 "+Float.MAX_VALUE);
		System.out.println("Long의 최소값 "+ Long.MIN_VALUE+" 최대값 "+Long.MAX_VALUE);
		System.out.println();
		
	}
}
