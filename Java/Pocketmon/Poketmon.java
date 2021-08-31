package Pocketmon;

public class Poketmon {
	private String name;
	
	public Poketmon(String name) {
		this.name=name;
	}
	
	//여기까지만 쓰면 주소값으로 받아오지만
	//////////////////////////////
	
	public String toString() {
		return name;
	}
	
	/*
	 * 어떤 오브젝트를 문자열로 표현하고 싶으시면 
	 * 위와 같이 클래스 안에 toString() 함수를 정의해 주시면 됩니다. 
	 * 그러면 System.out.println(오브젝트)를 할 경우 
	 * 자동으로 toString()함수가 사용되어 오브젝트가 문자열 형태로 출력됩니다.*/
	
}
