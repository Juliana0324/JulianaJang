package day0107;

/**
 * Marker펜을 추상화하여 생성한 클래스
 * 명사적 특징 : 뚜껑, 몸체, 색
 * 동사적 특징 : 쓴다
 * @author user
 *
 */
public class Marker {
	private int cap;
	private int body;
	private String color;
	
	/**
	 * 칠판에 생성된 마카펜 객체를 사용하여 "안녕하세요?"를 쓰는 일
	 * @return message
	 */
	public String write() {
		return "뚜껑 "+ cap +"개 "+body +"개 "+ color +"색인 마카펜으로 \"안녕하세요?\"를 칠판에 쓴다";
	}
	
	/**
	 * 칠판에 생성된 마카펜 객체를 사용하여 입력된 메세지를 쓰는 일
	 * @return msg
	 */
	public String write(String msg) {
		return color +"색인 마카펜으로 \""+msg+"\"를 칠판에 쓴다";
	}

	/**
	 * 생성된 마카펜 객체의 뚜껑의 개수를 설정하는일
	 * @param cap 설정할 뚜껑의 개수
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * 생성된 마카펜 객체의 뚜껑의 개수 반환하는 일
	 * @return 뚜껑의 개수
	 */
	public int getCap() {
		return cap;
	}
	
	
	/** 
	 * 생성된 마카펜 객체의 본체의 개수 설정
	 * @param body 
	 */
	public void setBody(int body) {
		this.body = body;
	}

	/** 
	 * 생성된 마카펜 객체의 본체의 개수 반환
	 * @return body 
	 */
	public int getBody() {
		return body;
	}



	/**
	 * 생성된 마카펜의 색깔 설정
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 생성된 마카펜의 색깔 반환
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	
}
