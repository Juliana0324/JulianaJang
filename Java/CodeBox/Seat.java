package CodeBox;

public class Seat {
    // 여기에 코드를 작성하세요.
	
	//예약자 이름담기
	private String name;
	
	//예약자 이름 리턴
	public String getName() {
		return name;
	}
	
	//예약자 이름 설정
	public void reserve(String name) {
		this.name = name;
	}
	
	//예약된 이름 없애주기 name = null
	public void cancel() {
		this.name = null;
	}
	
	//이미 예약된 자리인지 확인
	public boolean isOccupied() {
		if(name !=null) return true;	
		else return false;
	}
	
	//checkName이라는 이름으로 예약된 자리인지 확인하고, 불린값을 리턴해줍니다.
	public boolean match(String checkName) {
		if(checkName.equals(name)) return true;
		return false;
	}
	
	
}