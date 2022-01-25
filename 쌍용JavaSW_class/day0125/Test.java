package day0125;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public void weekend() {
		Calendar cal = Calendar.getInstance();
		int lastDay = 0, weekend=0;
		List<Integer> weekendList = new ArrayList<Integer>();
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		
		for(int i=0; i<12; i++) {
			cal.set(Calendar.MONTH, i);
			lastDay = cal.getActualMaximum(Calendar.DATE);
			for(int j=1; j<lastDay; j++) {
				cal.set(Calendar.DATE, j);
				weekend = cal.get(Calendar.DAY_OF_WEEK);
				if(weekend == 7 || weekend ==1) {
					weekendList.add(j);
				}
			}
			map.put(String.valueOf(i+1), weekendList);
			weekendList = new ArrayList<Integer>();
		}
		
		map.forEach((x,y) -> System.out.println(x+"¿ù: "+y));
		
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.weekend();
		
	}
}
