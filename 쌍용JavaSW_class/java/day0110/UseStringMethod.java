package day0110;

/**
 * String-문자열 클래스에서 제공하는 method의 사용
 * @author user
 *
 */
public class UseStringMethod {

	public static void main(String[] args) {
		String str = "ABcDef"; //기본형
		String str2 = new String("chiang324@naver.com"); //참조형
				
		System.out.println("글자수: "+ str.length());
		System.out.println("대문자: "+ str.toUpperCase());
		System.out.println("소문자: "+ str.toLowerCase());
		
		System.out.println("대문자: "+ str2.toUpperCase());
		
		String[] arr = str2.split("@");
		for(String a : arr) {
			System.out.print(a+" ");			
		}
		System.out.println();
		System.out.println(str2.contains("@"));
		System.out.println(str2.matches("chiang324@naver.com"));
		
		
		str = "AbcdEfbcd";
		System.out.println("앞에서부터 인덱스값: "+str.indexOf("c")); //2 - 인덱스 값
		System.out.println("앞에서부터 인덱스값: "+str.indexOf("Efb")); //4 - 맨앞의 인덱스 값
		System.out.println("인덱스값: "+str.indexOf("a")); //-1 - 인덱스 값
		System.out.println("뒤에서부터의 인덱스 값 "+str.lastIndexOf("c")); //7
		System.out.println("뒤에서부터의 인덱스 값 "+str.lastIndexOf("bcd")); //7
		System.out.println(str.charAt(2)); //존재하지 않으면 에러
		System.out.println();
		
		
	}

}
