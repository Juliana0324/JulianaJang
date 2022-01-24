package day0124;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {
	/**
	 * Hashtable = 기본생성자를 사용해서 11개의 행을 생성
	 * 멀티스레드 동시접근 불가능
	 */
	public void useHashtable() {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("A", "세심하다. 친절하다 ^^");
		map.put("B", "성질 드럽다");
		map.put("O", "우유부단하다");
		map.put("AB", "싸잌코@.,@");
		
		System.out.println(map.keySet()); //[A, AB, O, B] => 입력한대로 나오지 않느다
		System.out.println(map.containsKey("A"));
		System.out.println(map.containsKey("a")); //null
		//람다식
		map.forEach((x,y) -> System.out.println(x+" : "+y));
		
		System.out.println("---------------iterator 사용해서 키 출력------------------");
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		String key = "";
		
		while(iter.hasNext()) {
			key = iter.next();
			System.out.println(key +" "+map.get(key));
		}
		
		System.out.println("행의 수 : "+map.size());
		map.remove("O");
		System.out.println("행의 수 : "+map.size());
		map.clear();
		System.out.println("행의 수 : "+map.size());
		System.out.println("비어있나요? "+map.isEmpty());
	}
	
	public void useHashMap() {
		Map<String, Integer> map = new Hashtable<String, Integer>();
		TestVO tv = new TestVO("홍길동", 30);
		map.put(tv.getName(), tv.getAge());
		map.put("신윤복", 28);
		map.put("김홍도", 45);
		int gildongage = map.get("홍길동");
		System.out.println(gildongage);
		
		System.out.println(map.keySet());
		map.forEach((x,y) -> System.out.println(x+" : "+y));
		System.out.println("---------------iterator 사용해서 키 출력------------------");
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		String key = "";
		
		while(iter.hasNext()) {
			key = iter.next(); 
			System.out.println(key +" "+map.get(key));
		}
		
		System.out.println("행의 수 : "+map.size());
		map.remove("O");
		System.out.println("행의 수 : "+map.size());
		map.clear();
		System.out.println("행의 수 : "+map.size());
		System.out.println("비어있나요? "+map.isEmpty());
	}
	
	public static void main(String[] args) {
		TestMap tm = new TestMap();
		System.out.println("=============================HashTable=============================");
		tm.useHashtable();
		System.out.println("=============================HashMap=============================");
		tm.useHashMap();
	}
}
