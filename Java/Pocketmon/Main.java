package Pocketmon;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Poketmon> arr = new ArrayList<>();
		arr.add(new Poketmon("�̻��ؾ�"));
		arr.add(new Poketmon("�̻���Ǯ"));
		arr.add(new Poketmon("�̻��ز�"));
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(1));
		
		//HashMap
		//key -> Value
		
		HashMap<String, Poketmon> pokedex = new HashMap<>();
		//put ���
		pokedex.put("��ī��", new Poketmon("��ī��"));
		pokedex.put("������", new Poketmon("������"));
		pokedex.put("�̻��ؾ�", new Poketmon("�̻��ؾ�"));
		pokedex.put("�̻���Ǯ", new Poketmon("�̻���Ǯ"));
		
		pokedex.remove("�̻���Ǯ");
		Poketmon poke004 = pokedex.get("�̻���Ǯ");
		System.out.println(poke004);
		
		System.out.println(pokedex);
		
		
		//�ݺ��� 
		//keySet: HashMap�� �ִ� Ű���� �����ü� �ִ�
		for(String key:pokedex.keySet()) {
			System.out.println(pokedex.get(key));
		}
		
	}

}
