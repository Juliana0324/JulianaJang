package day0111;

public class HomeWork {
	public String socialNum;;
	boolean flag;
	

	//1번
	public HomeWork(String socialNum) {
		this.socialNum = socialNum;  
		if(letters()==true) {
			if(dash() == true) {
				System.out.println("입력주민번호 :"+socialNum);	
				System.out.println("생년월일: "+birthday());
				System.out.println("나이: "+age());
				System.out.println("성별: "+gender());
				System.out.println("띠: "+zodiac());
			}else {
				System.out.println("'-' 가 정상위치에 없습니다.");
			}
		}else {
			System.out.println("주민번호의 글자수가 다릅니다.");
		}
	}
	
	//2번
	public boolean letters() {
		flag = false;
		if(socialNum.length()==14) {
			flag=true;
		}
		return flag;
		
	}
	
	//3번
	public boolean dash() {
		flag = false;
		if(socialNum.indexOf("-") == 6) {
			flag = true;
		}
		return flag;
	}
	
	//4.
	public String birthday() {
	 	int fyear = Integer.valueOf(socialNum.substring(7,8));
	 	String year=socialNum.substring(0,2);
		
	 	switch(fyear){
		case 1:case 2:case 5:case 6:
	       year= "19" + year;
	       break;
		case 3:case 4:case 7:case 8:
		  year = "20" + year;
		  break;
		default:
			year = "18"+ year;
		}

	 	//month나 day의 출력시 0을 없애줘야함으로 정수로 변환
		int month= Integer.valueOf(socialNum.substring(2,4));
		int day = Integer.valueOf(socialNum.substring(4,6));
		
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

		if(gender.equals("1") || gender.equals("3")) {
			gender="남성";
		}else {
			gender = "여성";
		}
		return gender;
	}
	
	public String zodiac() {
		int year = Integer.valueOf(birthday().substring(0,4));
		String zodiac="";
		switch(year%12) {
		// 0-원숭이, 1- 닭, 2-개, 3- 돼지, 4-쥐 5-소, 6-호랑이, 7-토끼, 8-용, 9-뱀, 10-말, 11-양
			case 0: zodiac = "원숭이"; break;
			case 1: zodiac = "닭"; break;
			case 2: zodiac = "개"; break;
			case 3: zodiac = "돼지"; break;
			case 4: zodiac = "쥐"; break;
			case 5: zodiac = "소"; break;
			case 6: zodiac = "호랑이"; break;
			case 7: zodiac = "토끼"; break;
			case 8: zodiac = "용"; break;
			case 9: zodiac = "뱀"; break;
			case 10: zodiac = "말"; break;
			default: zodiac = "양";
		}
		return zodiac;
		
	}
	
	public static void main(String[] args) {
		new HomeWork("970324-2000000");
		System.out.println("------------------------------------");
		new HomeWork("000825-3000000");
		
		
	}

}
