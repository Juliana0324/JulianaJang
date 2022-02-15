package day0117;

import java.util.Calendar;
import java.util.Date;

public class RunTestOverrid {

	@Override
	public String toString() {
		return "객체가 출력될때 주소가 아닌 다른 메세지를 출력하도록 설정: "+super.toString();
	}
	
	public static void main(String[] args) {
	
		// 상속관계의 객체화 :  자식클래스를 생성히여 부모클래스에 저장
		// 부모클래스명 객체명 = new 자식클래스 생성자();
		TestOverrideSuper tosuper = new TestOverrideSub();
		tosuper.test(); //부모클래스의 test method ==> 부모만 정의된 메소드
		tosuper.temp(); //자식클래스의 temp method ==> 오버라이딩 된 자식 메소드
//		tosuper.sub();  => error

		System.out.println("-------------------------------------------------");
		//자식클래스로 객체화 : 부모클래스의 모든 자원과 자식클래스의 모든 자원을 사용할 수 있다
		TestOverrideSub tosub = new TestOverrideSub();
		tosub.test(); //부모클래스의 test method
		tosub.temp(); //자식클래스의 temp method
		tosub.sub(); //자식클래스만 가진 method
		
		System.out.println("-------------------------------------------------");
		//toString -> 객체를 출력했을때 객체의 주소가 아닌 값을 반환할때 toString()를 Override하여 클래스를 작성
		
		RunTestOverrid rto = new RunTestOverrid();
		System.out.println(rto.toString()); //주소
		
		String str = new String("오늘은 월요일");
		System.out.println(str.toString()); //메세지 출력
		
		Date date = new Date();
		System.out.println(date.toString()); //메세지 출력

		System.out.println(tosub.toString());  // 주소-> toString메소드를 출력하게됨
		
		Calendar cal = Calendar.getInstance();
		
		
	}
}
