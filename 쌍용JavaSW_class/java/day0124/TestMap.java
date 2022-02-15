package day0124;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {
	/**
	 * Hashtable = �⺻�����ڸ� ����ؼ� 11���� ���� ����
	 * ��Ƽ������ �������� �Ұ���
	 */
	public void useHashtable() {
		Map<String, String> map = new Hashtable<String, String>();
		map.put("A", "�����ϴ�. ģ���ϴ� ^^");
		map.put("B", "���� �巴��");
		map.put("O", "�����δ��ϴ�");
		map.put("AB", "�Ο���@.,@");
		
		System.out.println(map.keySet()); //[A, AB, O, B] => �Է��Ѵ�� ������ �ʴ���
		System.out.println(map.containsKey("A"));
		System.out.println(map.containsKey("a")); //null
		//���ٽ�
		map.forEach((x,y) -> System.out.println(x+" : "+y));
		
		System.out.println("---------------iterator ����ؼ� Ű ���------------------");
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		String key = "";
		
		while(iter.hasNext()) {
			key = iter.next();
			System.out.println(key +" "+map.get(key));
		}
		
		System.out.println("���� �� : "+map.size());
		map.remove("O");
		System.out.println("���� �� : "+map.size());
		map.clear();
		System.out.println("���� �� : "+map.size());
		System.out.println("����ֳ���? "+map.isEmpty());
	}
	
	public void useHashMap() {
		Map<String, Integer> map = new Hashtable<String, Integer>();
		TestVO tv = new TestVO("ȫ�浿", 30);
		map.put(tv.getName(), tv.getAge());
		map.put("������", 28);
		map.put("��ȫ��", 45);
		int gildongage = map.get("ȫ�浿");
		System.out.println(gildongage);
		
		System.out.println(map.keySet());
		map.forEach((x,y) -> System.out.println(x+" : "+y));
		System.out.println("---------------iterator ����ؼ� Ű ���------------------");
		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();
		String key = "";
		
		while(iter.hasNext()) {
			key = iter.next(); 
			System.out.println(key +" "+map.get(key));
		}
		
		System.out.println("���� �� : "+map.size());
		map.remove("O");
		System.out.println("���� �� : "+map.size());
		map.clear();
		System.out.println("���� �� : "+map.size());
		System.out.println("����ֳ���? "+map.isEmpty());
	}
	
	public static void main(String[] args) {
		TestMap tm = new TestMap();
		System.out.println("=============================HashTable=============================");
		tm.useHashtable();
		System.out.println("=============================HashMap=============================");
		tm.useHashMap();
	}
}
