package day0502.poly;

import java.util.HashMap;
import java.util.Map;

public class UseInterface {

	public static void main(String[] args) {
		//1. 값 할당
		Map<String, Action> map=new HashMap<String, Action>();
		
		//2. 값 할당
		map.put("a", new TestA());
		map.put("b", new TestB());
		map.put("c", new TestC());
		
		//3. 값 획등
		//객체 다형성: 하나의 이름으로 다른 동작 수행할 수 있다
		String key="a";
		if(map.containsKey(key)) {
			//4. key를 넣어 부모 얻기
			Action action=map.get(key);
			
			//5. 메소드 호출: Override된 메소드가 ㄹ호출됨
			System.out.println(action.execute());
			
		}
	}

}
