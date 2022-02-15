package day0110;

import java.io.UnsupportedEncodingException;

/**
 * 문자열(String)을 저장할 수 있는 class(java.lang.String)
 * @author user
 *
 */
public class UseString {

	public static void main(String[] args){
		//기본형 형식의 사용. str 객체가 문자열저장소의 주소를 직접 저장
		String str = "ABCDE";
		
		//참조형 형식 사용 str2 객체는 heap 주소를 저장했고, heap안에서 문자열 저장소의 주소를 저장
		String str2 = new String("ABCDE");
		
		System.out.println(str);
		System.out.println(str2);
		
		System.out.println("기본형:"+ (str=="ABCDE")); //true
		System.out.println("참조형:"+ (str2=="ABCDE")); //false
		System.out.println(str == str2); //참조형인 str2로 인해 주소값을 가져오기떄문에
		 								// str과 str2의 주소값이 다름으로 false 출력
		System.out.println(str.equals(str2));
		System.out.println(str.length());
		
		
		//1. str2에서 도메인 주소와 메일 주소를 분리
		str2 = "chiang324@naver.com";
		String[] arr = str2.split("@");
		for(String i : arr) {
			System.out.println(i);
		}
		
		System.out.println("도메인 주소: "+str2.substring(0,str2.indexOf("@")));
		System.out.println("메일 주소: "+str2.substring(str2.lastIndexOf("n")));
		
		//2. str2의 메일 주소를 유니코드로 변환
		 for(int i=0; i<str2.length(); i++) {
			 System.out.print((int)str2.charAt(i)+" ");
		 }
		
		
		
	}

}
