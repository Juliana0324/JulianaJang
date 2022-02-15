package day0124;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Homework0124 {
	//한달 평일 수 구하기
	public int weekday() {
		Calendar cal = Calendar.getInstance();
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		int weekend =0, weekendCnt=0;
		for(int i=1; i<lastDay; i++) {
			cal.set(Calendar.DATE, i);
			weekend = cal.get(Calendar.DAY_OF_WEEK);
			if(weekend == 7 || weekend ==1) {
				weekendCnt++;				
			}
		}
		
		weekendCnt = lastDay-weekendCnt; 
		return weekendCnt;
	} //weekday
	
	public String useTransport(String transportation, int km) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("마을버스", 800);
		map.put("버스", 1250);
		map.put("지하철", 1300);
		
		int fee = 0, addFee=0, thisMonth=0;
		String anw = "";
		switch(transportation) {
		case "마을버스": case "버스": case "지하철":
			fee = map.get(transportation);
			thisMonth =  fee*2*weekday();
			if(km>10) {
				addFee = (km-10)/5*100;
				thisMonth= ((fee+addFee)*2*weekday());
			}
			anw = "입력교통수단 :"+transportation+", 이동거리: "+km +"km, 기본요금 : "+fee+"원, 초과요금 "+addFee+"원\n"
					+"\t 이번달 "+weekday()+"일 왕복 교통비 :"+ thisMonth+"원";
			break;
		default:
			anw = transportation+"은/는 대중교통이 아닙니다.";
			
		}
		return anw;
	} //useTransport()
	
	public void whichOne(){
		Random ran = new Random();
		List<String> list = new ArrayList<String>();
	
		String[] transportation = {"마을버스", "지하철", "택시", "따릉이", "버스"};
		int km,transNum;
	
		
		for(int i=0; i<weekday(); i++) {
			km = Math.abs(ran.nextInt()%29)+1;
			transNum = Math.abs(ran.nextInt()%transportation.length);
			list.add(useTransport(transportation[transNum], km));			
			System.out.println((i+1)+"번째 :\t"+list.get(i));

		}
	} //whichOne()

	public static void main(String[] args) {
		Homework0124 hw = new Homework0124();
		System.out.println("--------------------1번--------------------");
		System.out.println(hw.useTransport("마을버스", 14));
		System.out.println();

		System.out.println("--------------------2번--------------------");
		hw.whichOne();
	
		
	}
}
