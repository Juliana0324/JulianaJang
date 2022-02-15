package day0121;

import java.util.List;

public class MainClass {

	
	public static void main(String[] args) {
		TestGeneric<Integer> tgen = new TestGeneric<Integer>();
		tgen.set(6);
		System.out.println(tgen.get());
		
		
		TestGeneric<String> tgenString = new TestGeneric<String>();
		tgenString.set("hi");
		System.out.println(tgenString.get());
		
		TestGeneric<String> tv = new TestGeneric<String>();
		TV t = new TV();
		tv.set(t.UhTV());
		System.out.println(tv.get());
		
		

	}
	
}
