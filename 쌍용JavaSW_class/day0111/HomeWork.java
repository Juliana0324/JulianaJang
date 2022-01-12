package day0111;

public class HomeWork {
	private String socialNum;
	

	//1번
	public HomeWork(String socialNum) {
		this.socialNum = socialNum;  
	}
	
	//2번
	public boolean letters() {
		return socialNum.length()==14;
		
	}
	
	//3번
	public boolean dash() {
		return socialNum.indexOf("-") == 6;
	}
	
	//4.
	public String birthday() {
	 	String fyear = socialNum.substring(7,8);
	 	int year=Integer.valueOf(socialNum.substring(0,2));
		
	 	//month나 day의 출력시 0을 없애줘야함으로 정수로 변환
		int month= Integer.valueOf(socialNum.substring(2,4));
		int day = Integer.valueOf(socialNum.substring(4,6));
				
	 	switch(fyear){
		case "1":case "2":case "5":case "6":
	       year= 1900 + year;
	       break;
		case "3":case "4":case "7":case "8":
		  year = 2000 + year;
		  break;
		default:
			year = 1800 + year;
		}

	 
		
		String birthday = year+"년 "+month+"월 "+day+"일 ";
		
		return birthday;
	}

	
	//5. 
	public int age() {
	 	int year = Integer.valueOf(birthday().substring(0,4));

		return 2022-year+1;
		
		
	}
	
	
	//6. 성별
	public String gender() {
		String gender= socialNum.substring(7,8);
		int genderFlag = Integer.parseInt(socialNum.substring(7,8));
		
		if(genderFlag%2 == 1) {
			gender="남성";
		} else {
			gender = "여성";
		}
		return gender;
	}
	
	public String zodiac() {
		int year = Integer.valueOf(birthday().substring(0,4));
		String[] zodiacArr= {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};
		return zodiacArr[year%12];
		
	}
	
	public static void main(String[] args) {
		 HomeWork hw1= new HomeWork("970324-2000000");
		if(hw1.letters()) {
			if(hw1.dash() ) {
				System.out.println("입력주민번호 :"+hw1.socialNum);	
				System.out.println("생년월일: "+hw1.birthday());
				System.out.println("나이: "+hw1.age());
				System.out.println("성별: "+hw1.gender());
				System.out.println("띠: "+hw1.zodiac());
			}else {
				System.out.println("'-' 가 정상위치에 없습니다.");
			}
		}else {
			System.out.println("주민번호의 글자수가 다릅니다.");
		}
		System.out.println("------------------------------------");
		HomeWork hw2= new HomeWork("000825-3000000");
		if(hw2.letters()) {	
			if(hw2.dash() ) { //dash method가 boolean을 반환하기 때문에 ==true인지를 비교할 필요는 없어요.
				System.out.println("입력주민번호 :"+hw2.socialNum);	
				System.out.println("생년월일: "+hw2.birthday());
				System.out.println("나이: "+hw2.age());
				System.out.println("성별: "+hw2.gender());
				System.out.println("띠: "+hw2.zodiac());
			}else {
				System.out.println("'-' 가 정상위치에 없습니다.");
			}
		}else {
		System.out.println("주민번호의 글자수가 다릅니다.");
	}
		
		
	}

}
