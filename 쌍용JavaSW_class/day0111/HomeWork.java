package day0111;

public class HomeWork {
	private String socialNum;
	

	//1��
	public HomeWork(String socialNum) {
		this.socialNum = socialNum;  
	}
	
	//2��
	public boolean letters() {
		return socialNum.length()==14;
		
	}
	
	//3��
	public boolean dash() {
		return socialNum.indexOf("-") == 6;
	}
	
	//4.
	public String birthday() {
	 	String fyear = socialNum.substring(7,8);
	 	int year=Integer.valueOf(socialNum.substring(0,2));
		
	 	//month�� day�� ��½� 0�� ������������� ������ ��ȯ
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
		int genderFlag = Integer.parseInt(socialNum.substring(7,8));
		
		if(genderFlag%2 == 1) {
			gender="����";
		} else {
			gender = "����";
		}
		return gender;
	}
	
	public String zodiac() {
		int year = Integer.valueOf(birthday().substring(0,4));
		String[] zodiacArr= {"������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��"};
		return zodiacArr[year%12];
		
	}
	
	public static void main(String[] args) {
		 HomeWork hw1= new HomeWork("970324-2000000");
		if(hw1.letters()) {
			if(hw1.dash() ) {
				System.out.println("�Է��ֹι�ȣ :"+hw1.socialNum);	
				System.out.println("�������: "+hw1.birthday());
				System.out.println("����: "+hw1.age());
				System.out.println("����: "+hw1.gender());
				System.out.println("��: "+hw1.zodiac());
			}else {
				System.out.println("'-' �� ������ġ�� �����ϴ�.");
			}
		}else {
			System.out.println("�ֹι�ȣ�� ���ڼ��� �ٸ��ϴ�.");
		}
		System.out.println("------------------------------------");
		HomeWork hw2= new HomeWork("000825-3000000");
		if(hw2.letters()) {	
			if(hw2.dash() ) { //dash method�� boolean�� ��ȯ�ϱ� ������ ==true������ ���� �ʿ�� �����.
				System.out.println("�Է��ֹι�ȣ :"+hw2.socialNum);	
				System.out.println("�������: "+hw2.birthday());
				System.out.println("����: "+hw2.age());
				System.out.println("����: "+hw2.gender());
				System.out.println("��: "+hw2.zodiac());
			}else {
				System.out.println("'-' �� ������ġ�� �����ϴ�.");
			}
		}else {
		System.out.println("�ֹι�ȣ�� ���ڼ��� �ٸ��ϴ�.");
	}
		
		
	}

}
