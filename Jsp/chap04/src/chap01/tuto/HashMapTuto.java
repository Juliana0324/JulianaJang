package chap01.tuto;

import java.util.HashMap;

public class HashMapTuto {

	//Map: Key�� Value�� �����͸� �����ϴ� JAVA�� �ڷᱸ��
	// Hashmap : Hash�˰����� �̿���  MAP�� ������
	public static void main(String [] args) {
	// HashMap<Key,Value>
	HashMap<String,Integer> member = new HashMap<>();
	
	member.put("ȫ�浿",13);
	member.put("��浿",15);
	member.put("��浿",20);
	
	//Map�� Key�� ���� Value�� ���� �� �ִ�
	int age =member.get("ȫ�浿");
	System.out.println(age);
	
	age=member.get("��浿");
	System.out.println(age);
	
	java.util.Map<String, String[]> paraMap =new HashMap<>();
	paraMap.put("hobby", new String[] {"movie","music","reading"});
	paraMap.put("fruit", new String[] {"apple","kiwi","pinapple"});
	
	System.out.println(paraMap);
	 //map.keySet() : key ��θ� �̷���� set�� ��ȯ
	System.out.println("member KeySet: "+member.keySet());
	System.out.println("para KeySet: "+paraMap.keySet()); //==>fruit,hobby 
	
	//Ű���� �̿��� ������ ��� ���� �� �ִ�
	
	
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
