package day0110;

public class HomeWork {
	
	//������
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
		String txt = "��������";
		if(oly.contains("��¿") || oly.contains("����")|| oly.contains("��¿")) {
			txt = "MZ����";			
		}
		return txt;
		
	}
	
	public static void main(String[] args) {
		HomeWork hm = new HomeWork();	
		
		System.out.println(hm.email());		
		System.out.println(hm.oldOrYoung("�ȳ��ϼ��� �ڹ��̷��� �����Դϴ�"));
	}

	
}
