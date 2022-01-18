package day0118;

/**
 * 사람의 공통 특징(눈,코,입,이름, 먹는일)은 Person클래스에서 가져다 사용하고
 * 자식클래스
 * 
 *  
 * 평균 성인의 싸움등급 2으로 본다
 * 힘은 1-10까지
 * @author user
 *
 */
public final class Clark extends Person implements Fly{
	
	public int power;
	
	public Clark() {
		super(3,1,1); //부모 클래스의 오버로딩된 생성자
		power= 8;
	}//clark
	
	//오버라이딩
	@Override
	public String eat() {
		return getName()+"이(가) 집에서 빵과 오트밀을 먹는다";
	}

	@Override
	public String eat(String menu, int price) {
		//public으로 되어있는 method를 호출하여 사용
		return getName()+"이 레스토랑에서 "+ menu+ "인 음식을 "+price+"$ 주고 사먹는다.";
	}

	
	public String power(String stone) {
		String result = "";
		
		if(stone.equals("크립토나이트")) {
			result = "힘이 빠지는 돌";
			power=1;
		}else if(stone.equals("다이아몬드")) { 
			result = "^^ 돈쥬세염 >< ";
			power = 10;
			
		}else { //기분 나쁜 돈
			result = "(ㅡㅡ +) 기부니가 좋지 않음";
			power = 12;
			
		}//end 
		return result;
	}//power

	
	//나는 기능을 인터페이스로부터 구현
	@Override
	public String upwardForce() {
		return getName()+"의 양력은 망토로부터 얻는다";
	}

	@Override
	public String drivingForce() {
		return getName()+"의 추진력은 무릎을 꿇어서 펴는 힘으로 얻는다";
	}

	
	
	
	
	
}
