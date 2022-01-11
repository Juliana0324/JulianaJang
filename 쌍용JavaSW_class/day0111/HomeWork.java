package day0111;

public class HomeWork {
	public String socialNum;;
	boolean flag;
	

	//1��
	public HomeWork(String socialNum) {
		this.socialNum = socialNum;  
		if(letters()==true) {
			if(dash() == true) {
				System.out.println("�Է��ֹι�ȣ :"+socialNum);	
				System.out.println("�������: "+birthday());
				System.out.println("����: "+age());
				System.out.println("����: "+gender());
				System.out.println("��: "+zodiac());
			}else {
				System.out.println("'-' �� ������ġ�� �����ϴ�.");
			}
		}else {
			System.out.println("�ֹι�ȣ�� ���ڼ��� �ٸ��ϴ�.");
		}
	}
	
	//2��
	public boolean letters() {
		flag = false;
		if(socialNum.length()==14) {
			flag=true;
		}
		return flag;
		
	}
	
	//3��
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

	 	//month�� day�� ��½� 0�� ������������� ������ ��ȯ
		int month= Integer.valueOf(socialNum.substring(2,4));
		int day = Integer.valueOf(socialNum.substring(4,6));
		
		String birthday = year+"�� "+month+"�� "+day+"�� ";

		
		return birthday;
	}

	
	//5. 
	public int age() {
	 	int year = Integer.valueOf(birthday().substring(0,4));

		return 2022-year+1;
		
		
	}
	
	
	//6. ����
	public String gender() {
		String gender= socialNum.substring(7,8);

		if(gender.equals("1") || gender.equals("3")) {
			gender="����";
		}else {
			gender = "����";
		}
		return gender;
	}
	
	public String zodiac() {
		int year = Integer.valueOf(birthday().substring(0,4));
		String zodiac="";
		switch(year%12) {
		// 0-������, 1- ��, 2-��, 3- ����, 4-�� 5-��, 6-ȣ����, 7-�䳢, 8-��, 9-��, 10-��, 11-��
			case 0: zodiac = "������"; break;
			case 1: zodiac = "��"; break;
			case 2: zodiac = "��"; break;
			case 3: zodiac = "����"; break;
			case 4: zodiac = "��"; break;
			case 5: zodiac = "��"; break;
			case 6: zodiac = "ȣ����"; break;
			case 7: zodiac = "�䳢"; break;
			case 8: zodiac = "��"; break;
			case 9: zodiac = "��"; break;
			case 10: zodiac = "��"; break;
			default: zodiac = "��";
		}
		return zodiac;
		
	}
	
	public static void main(String[] args) {
		new HomeWork("970324-2000000");
		System.out.println("------------------------------------");
		new HomeWork("000825-3000000");
		
		
	}

}
