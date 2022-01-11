package day0111;



/**
 * 문자열을 다루는 String class사용 <br>
 * 
 * 주의: 1.java.lang 패키지에 존재하는 클래스 이름으로 클래스를 생성하면 패키지에 정의한 
 * 		같은 이름의 클래스를 먼저 사용. (java.lang 패키지의 클래스를 사용하는것이 아니므로 error)
 * 		- import를 사용해도 동일 적용
 * 
 * 해결 : 1. 같은 이름의 클래스를 정의해야만 한다면 자바에서 정의하는 클래스를 
 * 		full path로 식별하여 사용
 * 		full path: 클래스를 사용할때 패키지명을 모두 명시하여 사용하는 문법
 * 		
 *       2.java.lang 패키지에 존재하는 클래스 이름으로 클래스를 만들지 x
 * 
 * @author user
 *
 */
public class UseString {
	
	public static void main(String[] args) {
		String str = "AbcdEfg"; //기본형
		String str2 = new String("abcde324@naver.com"); //참조형
		
		//str에서 Abc출력
		System.out.println(str.substring(0,3));
		System.out.println(str.substring(4));

		System.out.println("메일 주소: "+str2.substring(0,str2.indexOf("@")));
		System.out.println("도메인 주소: "+str2.substring(str2.lastIndexOf("n")));
		
	
		
		str = "서희수";
		System.out.println(str.startsWith("김"));
		System.out.println(str.endsWith("영"));
		System.out.println(str.endsWith("수"));
		str2 = "서울시 강남구 역삼동";
		System.out.println(str2.endsWith("동"));
		
		
		//문자열 결합 concat (문자열의 '+'와 마찬가지)
		str = "자바";
		String str3 = str.concat("SE");
		System.out.println(str3);
		System.out.println(str+"SE");
		
		//앞뒤 공백
		str = " Java SE ";
		System.out.println(str.trim());
		
		//문자열 치환 - replace
		//replaceAll(" ", "치환할 문자열")
		System.out.println(str.replaceAll(" ", "!"));
		
		//replace와 replaceAll의 차이
		str = "abcdeababaaababababcddee";
		System.out.println(str.replace("abc", "홓"));
		System.out.println(str.replace("[abc]", "홓"));
		//String regex정규표현식: [abc]=> a 또는 b 또는 c를 뜻함
		System.out.println(str.replaceAll("[abc]", "홓"));

		//메소드 체인
		str="안녕자바"; 
		str2 = str.replaceAll("안녕", "뇌절").replaceAll("안녕", "잘가");
		System.out.println(str2+": 두번째 replaceAll(\"안녕\",\"잘가\")은 안녕은 뇌절로 변경되어 안들어오징");
		
		//친구의 거친언행을 없애보자
		str= "나지금 피씨방이야.ㅆ ㅂ";
		String filterTxt= str.replaceAll("씨", "*").replaceAll("방", "*").replaceAll("ㅆ", "*").replaceAll("ㅂ", "*");
		System.out.println(filterTxt);
	
		//기본형 데이터형 값을 문자열로 저장
		int i=11;
		double l = 2022.011;
		String s= Integer.toString(i);
		System.out.println(s);
		//static method이기 때문에 클래스명.valueOf로 쓴다
		System.out.println(String.valueOf(i));
		System.out.println(String.valueOf(l));
		
		// toString()과 같은 경우 Null PointerException(NPE)을 발생시키지만 
		// valueOf는 "null"이라는 문자열로 처리한다.
		

		//////////////////////////////////////////////////////////////////////////////////////		
		//String의 초기화
		//1. null로 초기화
		//2. empty
		String strNull = null; //참조형 데이터의 초기화값이 없다는 뜻이다: 힙 주소를 가지지 않았다는 뜻
		String strEmpty = "";  //
		if(strNull == null) {
			System.out.println("힙의 주소를 저장하지 않았습니다.");
		} 
		
		if(strEmpty == "") {
			System.out.println("문자열 저장소의 주소를 저장하였습니다.");
		} 
	
		
		System.out.println(strEmpty.isEmpty()); //true
		//System.out.println(strNull.isEmpty()); //error :  Cannot invoke "String.isEmpty()" because "strNull" is null
		
		
	}//main
	
} //end UseString
