package PoketmonGO; 

import java.util.ArrayList;
import java.util.HashMap;

public class PokeBag {
    private HashMap<String, ArrayList<Pokemon>> pokemons = new HashMap<>();
    	
    
    //name 이라는 이름의 포켓몬을 모두가져오기
    public ArrayList<Pokemon> getPokemons(String name) {
		return pokemons.get(name);
    }

    
    //pokemons에 Pokemon인스턴스 넣는 메소드
    //1. 이미 같은 이름의 포켓몬 존재
    //2. 완전히 새로운 포켓몬인 경우
    public void add(Pokemon pokemon) {
    	String name = pokemon.name;
    	
    	//해당하는 ArrayList가없으면 생성
    	if(getPokemons(name) == null) {
    		ArrayList<Pokemon> arr = new ArrayList<>();
    		pokemons.put(name, arr);    		
    	}
    	getPokemons(name).add(pokemon);

    }

    public Pokemon getStrongest(String name) {
    	//name이름의 포켓몬 목록
    	ArrayList<Pokemon> pokeList = getPokemons(name);
    	
    	//존재하지 않는 이름일시 null
    	if(pokeList ==null) {
    		return null;    		
    	}
    	//null이 아닐경우 가장 강한 포켓몬 리턴
    	//return할 가장 강한 포켓몬을 담을변수
    	Pokemon strongest = null;
    	
    	//name에 해당하는 ArrayList를 가져오고 탐색
    	for(Pokemon pokemon: pokeList) {
    		//cp가 더큰 포켓몬이 나타나면 대체해주기
    		if(strongest == null || pokemon.cp>strongest.cp) {
    			strongest = pokemon;
    		}
    	}
    	return strongest;
    	
    	
    }

    //모든 포켓몬중 가장강한 포켓몬 가져오기
    public Pokemon getStrongest() {
    	Pokemon strongest = null;
    	
    	//HashMap 전체를 탐색(keySet)을 통해 얻은 key로 탐색
    	for(String key: pokemons.keySet()) {
    		Pokemon p = getStrongest(key);
    		
    		if(strongest == null || p.cp>strongest.cp) {
    			strongest = p;
    		}
    	}
		return strongest;
    }
}