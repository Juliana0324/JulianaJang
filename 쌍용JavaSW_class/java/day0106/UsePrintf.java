package day0106;

import java.time.LocalDate;

/**
 * VA를 도입하여 작성된 메소드 사용
 * printf 사용방법
 * @author user
 *
 */
public class UsePrintf {

	public static void main(String[] args) {
		int i=2022;
		char a= 'A';
		double d = 202.231953;
		String s ="하이";
		
		System.out.printf("정수 : i의 값은 %d입니다\n",i);
		System.out.printf("정수출력 자릿수: [%8d]\n",i);
		System.out.printf("정수출력 자릿수: [%-8d]\n",i);

		
		System.out.printf("문자 : %c\n",a);
		System.out.printf("문자 출력 자릿수: [%5c]\n",a);
		System.out.printf("문자 출력 자릿수: [%-5c]\n",a);

		System.out.printf("실수 : %8.3f\n",d);
		System.out.printf("실수 : %-8.3f\n",d);
		System.out.printf("문자열 : %s\n",s);
		
		System.out.printf("%d %-4c %.2f\n",i,a,d);
		
		System.out.println();
		////////////////////////////////////////////////
		int year = 2022;
		int month =1;
		int day = 6;
		char week ='T';
		String msg = "오늘은 목요일입니다";
		
		
		System.out.printf("오늘은 %d년 %d월 %d일 %c요일 오늘의 메세지: %s\n",year, month,day,week,msg);
		System.out.format("오늘은 %d년 %d월 %d일 %c요일 오늘의 메세지: %s\n",year, month,day,week,msg);
		System.out.println("오늘은 "+year+"년 "+month+"월 "+day+"일 "+week+"요일 오늘의 메세지: "+msg);
		
		LocalDate currentTime = LocalDate.now();
		System.out.println(currentTime);
		
		
	}
	
	
}
