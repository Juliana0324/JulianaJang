package day0118;

/**
 * 사람의 공통 특징(눈,코,입,이름, 먹는일)은 Person클래스에서 가져다 사용하고
 * 자식클래스
 * 
 * 싸움레벨은 1-10까지 존재 
 * 평균 성인의 싸움등급 3으로 본다
 * @author user
 *
 */
public class HongGilDong extends Person{
	
	private int myLevel;
	
	public HongGilDong() {
		super();
		myLevel = 5;
	}//홍길동
	
	@Override
	public String eat() {
		return getName()+"이 집에서 밥을 먹습니다.";
	}
	
	//오버라이딩
	@Override
	public String eat(String menu, int price) {
		//public으로 되어있는 method를 호출하여 사용
		return getName()+"이 주막에서 "+ menu+ "인 음식을 "+price+"냥 주고 사먹는다.";
	}
	

	
	
	public String fight(int yourLevel) {
		String resultMsg = "";
		
		if(myLevel <yourLevel) { //지는경우
			resultMsg ="OTL 싸움에서 졌음";
			myLevel--;
			if(myLevel <1) {
				myLevel = 1;
			}//end if
			
		}else if(myLevel>yourLevel) { //이기는 경우
			resultMsg ="V('.^)V 싸움에서 이겼음";
			myLevel++;
			if(myLevel >10) {
				myLevel = 10;
			}//end if
			
		}else { //비기는경우
			resultMsg = "(ㅡㅡ;;)비겼다!";
			
		}//end if
	
		return resultMsg;
	}
	
	
}
