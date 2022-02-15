package day0124;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Homework0124 {
	//�Ѵ� ���� �� ���ϱ�
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
		map.put("��������", 800);
		map.put("����", 1250);
		map.put("����ö", 1300);
		
		int fee = 0, addFee=0, thisMonth=0;
		String anw = "";
		switch(transportation) {
		case "��������": case "����": case "����ö":
			fee = map.get(transportation);
			thisMonth =  fee*2*weekday();
			if(km>10) {
				addFee = (km-10)/5*100;
				thisMonth= ((fee+addFee)*2*weekday());
			}
			anw = "�Է±������ :"+transportation+", �̵��Ÿ�: "+km +"km, �⺻��� : "+fee+"��, �ʰ���� "+addFee+"��\n"
					+"\t �̹��� "+weekday()+"�� �պ� ����� :"+ thisMonth+"��";
			break;
		default:
			anw = transportation+"��/�� ���߱����� �ƴմϴ�.";
			
		}
		return anw;
	} //useTransport()
	
	public void whichOne(){
		Random ran = new Random();
		List<String> list = new ArrayList<String>();
	
		String[] transportation = {"��������", "����ö", "�ý�", "������", "����"};
		int km,transNum;
	
		
		for(int i=0; i<weekday(); i++) {
			km = Math.abs(ran.nextInt()%29)+1;
			transNum = Math.abs(ran.nextInt()%transportation.length);
			list.add(useTransport(transportation[transNum], km));			
			System.out.println((i+1)+"��° :\t"+list.get(i));

		}
	} //whichOne()

	public static void main(String[] args) {
		Homework0124 hw = new Homework0124();
		System.out.println("--------------------1��--------------------");
		System.out.println(hw.useTransport("��������", 14));
		System.out.println();

		System.out.println("--------------------2��--------------------");
		hw.whichOne();
	
		
	}
}
