package PoketmonGO; 

import java.util.ArrayList;
import java.util.HashMap;

public class PokeBag {
    private HashMap<String, ArrayList<Pokemon>> pokemons = new HashMap<>();
    	
    
    //name �̶�� �̸��� ���ϸ��� ��ΰ�������
    public ArrayList<Pokemon> getPokemons(String name) {
		return pokemons.get(name);
    }

    
    //pokemons�� Pokemon�ν��Ͻ� �ִ� �޼ҵ�
    //1. �̹� ���� �̸��� ���ϸ� ����
    //2. ������ ���ο� ���ϸ��� ���
    public void add(Pokemon pokemon) {
    	String name = pokemon.name;
    	
    	//�ش��ϴ� ArrayList�������� ����
    	if(getPokemons(name) == null) {
    		ArrayList<Pokemon> arr = new ArrayList<>();
    		pokemons.put(name, arr);    		
    	}
    	getPokemons(name).add(pokemon);

    }

    public Pokemon getStrongest(String name) {
    	//name�̸��� ���ϸ� ���
    	ArrayList<Pokemon> pokeList = getPokemons(name);
    	
    	//�������� �ʴ� �̸��Ͻ� null
    	if(pokeList ==null) {
    		return null;    		
    	}
    	//null�� �ƴҰ�� ���� ���� ���ϸ� ����
    	//return�� ���� ���� ���ϸ��� ��������
    	Pokemon strongest = null;
    	
    	//name�� �ش��ϴ� ArrayList�� �������� Ž��
    	for(Pokemon pokemon: pokeList) {
    		//cp�� ��ū ���ϸ��� ��Ÿ���� ��ü���ֱ�
    		if(strongest == null || pokemon.cp>strongest.cp) {
    			strongest = pokemon;
    		}
    	}
    	return strongest;
    	
    	
    }

    //��� ���ϸ��� ���尭�� ���ϸ� ��������
    public Pokemon getStrongest() {
    	Pokemon strongest = null;
    	
    	//HashMap ��ü�� Ž��(keySet)�� ���� ���� key�� Ž��
    	for(String key: pokemons.keySet()) {
    		Pokemon p = getStrongest(key);
    		
    		if(strongest == null || p.cp>strongest.cp) {
    			strongest = p;
    		}
    	}
		return strongest;
    }
}