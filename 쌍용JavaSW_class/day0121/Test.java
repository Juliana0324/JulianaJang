package day0121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public void password() {
		String passwordSet = "1234567890-=qwertyuiop[[]asdfghjklzxcvbnm,./;'";
		int ran = (int)(Math.random()*6)+7, ranPass;
		
		List<String> passList=new ArrayList<String>(ran);

		for(int i=0; i<ran; i++) {
			ranPass=(int)(Math.random()*passwordSet.length());
			passList.add(i, passwordSet.substring(ranPass,ranPass+1));
			System.out.print(passList.get(i));
		}

	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.password();
	}
}
