package day0110;

public class HomeWork {
	
	//������
	public HomeWork() {}
	
	public boolean emailValidation(String myEmail) {		
		boolean foo = false;
		int atIndex = myEmail.indexOf("@");
		int dotIndex = myEmail.indexOf(".");
		if (atIndex!=-1 && dotIndex!=-1 && myEmail.length()>4 && atIndex<dotIndex){
			foo = true;
		}
		return foo;
	}
	
	public String oldOrYoung(String oly) {
		String txt = "��������";
//		if(oly.contains("��¿") || oly.contains("����")|| oly.contains("��¿")) {
		if(oly.indexOf("��¿")!= -1 || oly.indexOf("����")!= -1 || oly.contains("��¿")) {
			txt = "MZ����";			
		}//end if
		return txt;
		
	}//end oldOrYoung
	
	
	
	public static void main(String[] args) {
		HomeWork hm = new HomeWork();	
		
		String myEmail ="chiang324@naver.com";
		System.out.println(hm.emailValidation(myEmail));		
		System.out.println(hm.oldOrYoung("�ȳ��ϼ��� �ڹ��̷��� �����Դϴ�"));
	}

	
}
