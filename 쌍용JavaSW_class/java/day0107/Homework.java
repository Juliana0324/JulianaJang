package day0107;

public class Homework {

	public static void main(String[] args) {
		// 선정된 대상으로부터 객체 모델링
		// 신라면, 오징어 짬뽕, 진라면 => 클래스만들고 라면 끓이기
		// 클래스 다이어그램 작성, 
		// 객체 생성
		// 사용을 해보시오
		Ramen shin = new Ramen();
		shin.setRamenName("신라면");
		shin.setWater(500);
		shin.setMinute(3);
		shin.makeRame();
	}

}
