package day0121;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Homework0121 {
	int cnt;
	public static final int START_DAY=1;
	
	public void password() {
		String passwordSet = "`1234567890-=qwertyuiop[]asdfghjkl;’zxcvbnm,./QWERTYUIOASDFGHJKLZXCVBNM";
		int ran = (int)(Math.random()*6)+7, ranPass;

		List<String> passList=new ArrayList<String>();

		for(int i=0; i<ran; i++) {
			ranPass=(int)(Math.random()*passwordSet.length());
			passList.add(i, passwordSet.substring(ranPass,ranPass+1));
			System.out.print(passList.get(i));
		}
		System.out.println();
	}//password
	
	public void realCalendar(int year, int month) {
		Calendar cal = Calendar.getInstance(); //시스템의 현재날짜정보
		String[] weekVar = "일,월,화,수,목,금,토".split(",");
		
		//입력되는 년과 월에 해당하는 날짜를 출력하기 위해 입력되는 년과 월로 cal객체를 설정
		//사용자가 원하는 달력
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		
		System.out.printf("------------------%d년 %d월 달력------------------------\n", year,month);
		for(String week : weekVar) {
			System.out.print(week+"\t");
		}
		System.out.println();
		
		//선생님 풀이
		int dayOfWeek = Calendar.DAY_OF_WEEK; //요일
		for(int tempDay=1; ;tempDay++) { //1일로부터 시작하고 끝일은 알 수 없음
			cal.set(Calendar.DAY_OF_MONTH, tempDay); //증가하는 입시 날짜로 달력의 "일" 설정
			if(tempDay != cal.get(Calendar.DAY_OF_MONTH)) {
				break;
			}
			switch(tempDay) {
			case START_DAY :
				for(int blank=1; blank<cal.get(dayOfWeek);blank++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%d\t",tempDay);
			switch(cal.get(dayOfWeek)) {
				case Calendar.SATURDAY: System.out.println();
			}
			
		}//endfor
		System.out.println();
		
//		System.out.println();
//		int lastDate = cal.getActualMaximum(Calendar.DATE);
//		cal.set(year, month-1,1); 
//		int weekday = cal.get(Calendar.DAY_OF_WEEK);
//		for(int i=1; i<=lastDate;i++) {
//			if(i==1) {
//				for(int j=1; j<weekday;j++) {
//					System.out.print("\t");
//				}
//			}
//			System.out.print(i+"\t");
//			if(weekday%7==0) {
//				System.out.println();
//			}
//			weekday++;
//		}
		
	}//realCalendar
	

	public List<String> randomPerson() {
		String[] students = {"강명준","강산","강현모","권용현","김예진","김의정","김정하","김진영","김현우"};
		int imsi = (int)(Math.random()*10)+10, stu;
		List<String> stuList = new ArrayList<String>();

		for(int i=0; i<imsi; i++) {
			stu  = (Math.abs(new Random().nextInt())%students.length);
			stuList.add(students[stu]);
		}
		return stuList;
	}//randomPerson
	

	public void sameStudent() {
		List<String> stulist = randomPerson();
		List<Integer> sameStuList = new ArrayList<Integer>();
		System.out.println(stulist);
		for(int i=0; i<stulist.size();i++) {
			for(int j=0; j<i; j++) {
				if(stulist.get(i).equals(stulist.get(j))){
					cnt++;
				}
			}
			sameStuList.add(cnt);
			System.out.println(stulist.get(i)+" 반복횟수: "+ sameStuList.get(i));			
			cnt=0;
		}		
	}//sameStudent
		
	
	public static void main(String[] args) {
		Homework0121 hw = new Homework0121();

		System.out.println("-------------임시 비밀번호----------------");
		hw.password();
		System.out.println("-------------달력출력----------------");
		hw.realCalendar(2022,1);
		System.out.println("-------------학생들 목록----------------");
		for(String students : hw.randomPerson()) {
			System.out.print(students+" ");
		}
		System.out.println();
		System.out.println("-------------람다식 이용한 학생들 목록----------------");
		List<String> students = hw.randomPerson();
		students.forEach(x->System.out.print(x));
		
		System.out.println("-------------중복 학생 수----------------");
		//hw.sameStudent();
		List<String> stulist = hw.randomPerson();
		Set<String> set = new HashSet<String>(stulist);
		System.out.println(stulist);
		for(String stu: set) {
			System.out.println(stu +" 중복횟수: "+Collections.frequency(stulist, stu)+"번");
		}

		

		
	}//main
}//class


