package day0110;

public class HomeWork {
	
	//»ý¼ºÀÚ
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
		String txt = "´ÄÀº¼¼´ë";
//		if(oly.contains("¾îÂ¿") || oly.contains("³úÀý")|| oly.contains("ÀúÂ¿")) {
		if(oly.indexOf("¾îÂ¿")!= -1 || oly.indexOf("³úÀý")!= -1 || oly.contains("ÀúÂ¿")) {
			txt = "MZ¼¼´ë";			
		}//end if
		return txt;
		
	}//end oldOrYoung
	
	
	
	public static void main(String[] args) {
		HomeWork hm = new HomeWork();	
		
		String myEmail ="chiang324@naver.com";
		System.out.println(hm.emailValidation(myEmail));		
		System.out.println(hm.oldOrYoung("¾È³çÇÏ¼¼¿ä ÀÚ¹ÙÀÌ·ÐÀº ³úÀýÀÔ´Ï´Ù"));
	}

	
}
