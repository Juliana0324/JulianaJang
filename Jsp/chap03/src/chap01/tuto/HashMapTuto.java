package chap01.tuto;

import java.util.HashMap;

public class HashMapTuto {

	//Map: Key와 Value로 데이터를 저장하는 JAVA의 자료구조
	// Hashmap : Hash알고리즘을 이용해  MAP을 구현함
	public static void main(String [] args) {
	// HashMap<Key,Value>
	HashMap<String,Integer> member = new HashMap<>();
	
	member.put("홍길동",13);
	member.put("고길동",15);
	member.put("김길동",20);
	
	//Map은 Key를 통해 Value를 꺼낼 수 있다
	int age =member.get("홍길동");
	System.out.println(age);
	
	age=member.get("김길동");
	System.out.println(age);
	
	java.util.Map<String, String[]> paraMap =new HashMap<>();
	paraMap.put("hobby", new String[] {"movie","music","reading"});
	paraMap.put("fruit", new String[] {"apple","kiwi","pinapple"});
	
	System.out.println(paraMap);
	 //map.keySet() : key 들로만 이루어진 set을 반환
	System.out.println("member KeySet: "+member.keySet());
	System.out.println("para KeySet: "+paraMap.keySet()); //==>fruit,hobby 
	
	//키들을 이용해 값들을 모두 꺼낼 수 있다
	
	
	System.out.println(paraMap.keySet());
	System.out.println(paraMap.get("fruit"));
	String[] fruits =paraMap.get("fruit");
	String [] hobbies=paraMap.get("hobby");
	
	
	for(int i=0;i<fruits.length;++i) {
		System.out.println(fruits[i]);
	}
	for(int i=0;i<hobbies.length;++i) {
		System.out.println(hobbies[i]);
	}
	
	for(String key: paraMap.keySet()) {
		String [] valueArray = paraMap.get(key);
		for(int i=0;i<valueArray.length;i++) {
			System.out.print(valueArray[i]+" ");
			}
		}
	}

}
