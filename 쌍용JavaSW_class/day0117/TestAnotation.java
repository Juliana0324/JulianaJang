package day0117;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TestAnotation {
		
	@Deprecated
	public void test() {
		System.out.println("¿œ//");
	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	public void temp() {
		int i;
		
		List l =null;
		
	}
	
	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date.getYear()+1900);
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		
		TestAnotation ta = new TestAnotation();
		ta.test();
	}
	
}
