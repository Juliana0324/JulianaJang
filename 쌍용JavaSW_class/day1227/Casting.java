/* 
	강제형변환
	개발자가 필요한 데이터형으로 변환하는것
	(변환할 데이터형)변수명 또는 상수;

*/
class Casting{
	public static void main(String[] args) 
	{
		char c = 'A';
		int i = c;
		System.out.println(c+"의 Unicode : "+i);
		
		float f = (float)12.27;
		i = (int)f;
		System.out.println("값 손실 발생: "+f+", 변환된 값: "+i);

		//기본형 데이터형을 참조형으로 강제형변환
		//i = 12;
		//String s = i;
		//==> error
		//기본형 i를 참조형 String으로 casting할수 없음
		String s = "2021";
		int nu = Integer.parseInt(s);
		System.out.println(nu);

		
	}
}
