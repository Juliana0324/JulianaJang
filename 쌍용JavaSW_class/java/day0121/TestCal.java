package day0121;

import java.util.Calendar;

public class TestCal {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		String[] weekVar = "일,월,화,수,목,금,토".split(",");
		
		int lastDate = cal.getActualMaximum(Calendar.DATE);
		int weekday= cal.get(Calendar.DAY_OF_WEEK);
		
		for(String week : weekVar) {
			System.out.print(week+"\t");
		}
		System.out.println();
		
		for(int i=1; i<=weekday; i++) {
			System.out.print("\t");
		}
		for(int i=1; i<=lastDate; i++) {
			System.out.print(i+"\t");
			if(i%7==1 || i==1) {
				System.out.println();

			}
		}
		System.out.println();
		

	}

}
