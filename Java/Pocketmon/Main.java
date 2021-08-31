package Pocketmon;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Poketmon> arr = new ArrayList<>();
		arr.add(new Poketmon("이상해씨"));
		arr.add(new Poketmon("이상해풀"));
		arr.add(new Poketmon("이상해꽃"));
		
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println(arr.get(1));
		
		//HashMap
		//key -> Value
		
		HashMap<String, Poketmon> pokedex = new HashMap<>();
		//put 사용
		pokedex.put("피카츄", new Poketmon("피카츄"));
		pokedex.put("라이츄", new Poketmon("라이츄"));
		pokedex.put("이상해씨", new Poketmon("이상해씨"));
		pokedex.put("이상해풀", new Poketmon("이상해풀"));
		
		pokedex.remove("이상해풀");
		Poketmon poke004 = pokedex.get("이상해풀");
		System.out.println(poke004);
		
		System.out.println(pokedex);
		
		
		//반복문 
		//keySet: HashMap에 있는 키들을 가져올수 있다
		for(String key:pokedex.keySet()) {
			System.out.println(pokedex.get(key));
		}
		
	}

}
