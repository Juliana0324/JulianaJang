package day0118;

import java.util.ArrayList;
import java.util.List;

import day0105.Modifiers;


/**
 * 다른 패키지의 클래스를 참조하여 사용할떄
 * @author user
 *
 */
public class TestImport {
	
	public static void main(String[] args) {
		Modifiers mod = new Modifiers();
		mod.instanceA=10;
		System.out.println(mod.instanceA);
		
		List<String> l =new ArrayList<String>();
		l.add("1");
		System.out.println(l.get(0));
		
		java.awt.List test = null; // fullpath
		System.out.println(test);
		
		
	}
}
