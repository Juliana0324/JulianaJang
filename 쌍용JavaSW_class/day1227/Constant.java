/*
	Constant : 프로그램 기준에서 가독성 있게 사용할때
*/

class Constant{
	//기준값으로 사용하는 Constant는 class Field에서만 사용가능
	public static final int MAX_SCORE=100;
	public static final int MIN_SCORE=0;

	public static void main(String[] args) {
	//	public static final int MAX_SCORE=100; ==> Error

		int myScore = 85;

		System.out.println(MAX_SCORE + "/" + MIN_SCORE);
		System.out.println(Constant.MAX_SCORE+ "/"+ Constant.MIN_SCORE);

		System.out.println("내점수와 최고 점수의 차이: "+(MAX_SCORE- myScore));
	
	
	}
}
