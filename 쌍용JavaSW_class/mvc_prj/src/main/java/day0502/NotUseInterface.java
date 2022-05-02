package day0502;

import java.util.HashMap;
import java.util.Map;

public class NotUseInterface {

	
	public static void main(String[] args) {
		//부모가 일치하지 않은 클래스를 Map에 넣고 사용
		
		//1. map 생성
		Map<String, Object> map=new HashMap<String, Object>();
		
		//2. 값 할당
		map.put("a", new TestA());
		map.put("b", new TestB());
		map.put("c", new TestC());
		
		//3. 값사용(키얻기)
		//객체다형성을 사용하지 않으면 각각의 클래스를 얻어서 비교하고 처리해야한다(중복코딩증가)
		String key="a";
		if("a".equals(key)) { //키 비교
			TestA ta= (TestA)map.get(key);
			System.out.println(ta.execute());
		}
		if("b".equals(key)) {
			TestB tb= (TestB)map.get(key);
			System.out.println(tb.execute());
		}
		if("c".equals(key)) {
			TestC tc= (TestC)map.get(key);
			System.out.println(tc.execute());
		}
		
	}//main

}
