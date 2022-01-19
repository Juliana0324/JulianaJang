package day0119;

/**
 * String, 
 * StringBuffer(JDK1.0부터) - 동시접근불가(동기화), 
 * StringBuilder(JDK 1.5이후) - 동시접근가능(동기화x) 
 * 속도: Builder > Buffer
 * @author user
 *
 */
public class UseString {

	public static void main(String[] args) {
		String str = "안녕";
		str += "하세요? ";
		
		System.out.println(str + "눈오는 수요일 "+"오전입니다");
		
	/*	class에서 보이는 방식
	 
	String str = "\uC548\uB155";
    str = (new StringBuilder(String.valueOf(str))).append("\uD558\uC138\uC694? ").toString();
    System.out.println((new StringBuilder(String.valueOf(str))).append("\uB208\uC624\uB294 \uC218\uC694\uC77C ").append("\uC624\uC804\uC785\uB2C8\uB2E4").toString());
   
   */
		
		//생성자
		//StringBuilder, StringBuffer => 정수 실수 문자 문자열 불린을 추가할수 있음
		StringBuilder sb =new StringBuilder();
		sb.append(19).append("th. Hi");
		System.out.println(sb);
		
		System.out.println(sb.length());
		String str1 = sb.toString(); //String형으로 변경 => StringBuilder에는 UpperCase나 LowerCase가 없음
		System.out.println(str1.toUpperCase());

		sb.insert(0, "Today is ");
		System.out.println(sb);
		
		sb.delete(0, 5);
		System.out.println(sb);
		
		
		System.out.println("----------------split메소드--------------------------");
		//StringTokener와  비슷한 String method
		//split은 배열로
		String csvData = "Java, Oracle, Jdbc, Html";
		String[] arr = csvData.split(", ");
		for(String lang:arr) {
			System.out.println(lang);
		}

	}
}
