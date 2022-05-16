package day0516.run;


import java.util.List;

import day0516.assembly.Assembly;
import day0516.service.Service;

/**
 * 의존성 주입받은 클래스를 얻어서 의존성 주입받은 클래스를 사용하는 일.
 * @author user
 *
 */
public class UseBean {
	
	
	
	
	public static void main(String[] args) {
		//1. 조립자 클래스 생성
		Assembly ass = new Assembly();
		
		//2. 의존성 주입 받을 클래스 얻기
		Service service = ass.getBean();
		
		//3. 의존성 주입받은 객체 사용
		service.addMember("테스트");
		
		List<String> list = service.searchMember();
		System.out.println(list);
		
	}//main
}
