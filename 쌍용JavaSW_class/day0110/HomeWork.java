package day0110;

public class HomeWork {
	
	//생성자
	public HomeWork() {}
	
	public boolean email() {
		String myEmail ="chiang324@naver.com";
		
		boolean foo = false;
		if (myEmail.contains("@") && myEmail.contains(".") && myEmail.length()>4){
			foo = true;
		}
		return foo;
	}
	
	public String oldOrYoung(String oly) {
		String txt = "늙은세대";
		if(oly.contains("어쩔") || oly.contains("뇌절")|| oly.contains("저쩔")) {
			txt = "MZ세대";			
		}
		return txt;
		
	}
	
	public static void main(String[] args) {
		HomeWork hm = new HomeWork();	
		
		System.out.println(hm.email());		
		System.out.println(hm.oldOrYoung("안녕하세요 자바이론은 뇌절입니다"));
	}

	
}
