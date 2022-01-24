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
		String passwordSet = "`1234567890-=qwertyuiop[]asdfghjkl;��zxcvbnm,./QWERTYUIOASDFGHJKLZXCVBNM";
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
		Calendar cal = Calendar.getInstance(); //�ý����� ���糯¥����
		String[] weekVar = "��,��,ȭ,��,��,��,��".split(",");
		
		//�ԷµǴ� ��� ���� �ش��ϴ� ��¥�� ����ϱ� ���� �ԷµǴ� ��� ���� cal��ü�� ����
		//����ڰ� ���ϴ� �޷�
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		
		System.out.printf("------------------%d�� %d�� �޷�------------------------\n", year,month);
		for(String week : weekVar) {
			System.out.print(week+"\t");
		}
		System.out.println();
		
		//������ Ǯ��
		int dayOfWeek = Calendar.DAY_OF_WEEK; //����
		for(int tempDay=1; ;tempDay++) { //1�Ϸκ��� �����ϰ� ������ �� �� ����
			cal.set(Calendar.DAY_OF_MONTH, tempDay); //�����ϴ� �Խ� ��¥�� �޷��� "��" ����
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
		String[] students = {"������","����","������","�ǿ���","�迹��","������","������","������","������"};
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
			System.out.println(stulist.get(i)+" �ݺ�Ƚ��: "+ sameStuList.get(i));			
			cnt=0;
		}		
	}//sameStudent
		
	
	public static void main(String[] args) {
		Homework0121 hw = new Homework0121();

		System.out.println("-------------�ӽ� ��й�ȣ----------------");
		hw.password();
		System.out.println("-------------�޷����----------------");
		hw.realCalendar(2022,1);
		System.out.println("-------------�л��� ���----------------");
		for(String students : hw.randomPerson()) {
			System.out.print(students+" ");
		}
		System.out.println();
		System.out.println("-------------���ٽ� �̿��� �л��� ���----------------");
		List<String> students = hw.randomPerson();
		students.forEach(x->System.out.print(x));
		
		System.out.println("-------------�ߺ� �л� ��----------------");
		//hw.sameStudent();
		List<String> stulist = hw.randomPerson();
		Set<String> set = new HashSet<String>(stulist);
		System.out.println(stulist);
		for(String stu: set) {
			System.out.println(stu +" �ߺ�Ƚ��: "+Collections.frequency(stulist, stu)+"��");
		}

		

		
	}//main
}//class


