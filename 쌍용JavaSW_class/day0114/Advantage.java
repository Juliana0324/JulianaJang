package day0114;

public class Advantage extends Person{
	
	
	
	public String power(String strength) {
		String msg = super.getName()+"의 강점은 "+ strength+"입니다.";
		return msg;
	}
	
}
