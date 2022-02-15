package day0104;

/**
 * 특수 문자의 사용
 * @author user
 *
 */
public class UseEscapeCharacter {

	public static void main(String[] args) {
		//안녕하세요를 한번 출력하는 코드를 작성
		System.out.println("안녕하세요?");
		System.out.println("'안녕하세요?'");
		System.out.println("\"안녕하세요?\"");
   
		//다음 줄로 띄어쓰기 \n
		System.out.println("다음 줄로 \n넘어가기");
		

		// 탭키 효과 = \t
		System.out.println("안녕\t하세요");
		
		// return 커서를 현재행의 앞으로 이동(윈도우만 존재)= \r
		// 특수문자를 따로쓰면 줄을 변경하지만 TextArea
		// 에서 enter key를 누르면 \r\n코드 2개가 생긴다
		System.out.println("\r안녕하세요");

		// \"
		System.out.println("쌍따옴표는 \"\" 이렇게 씁니다 ");
		
		// \'  = 그냥 써도 괜찮음
		System.out.println("홑따옴표 \'\' 이렇게 씁니다 ");

		// \b = backspace: 실제출력시 보이지 않음
		System.out.println("backspace\b");

		
		// \f = 프린터의 한줄을 변경
		
		// \\ -> 역슬래시 표시 : ex) 윈도우즈 os 경로 표시
		System.out.println("\\");
		System.out.println("e:\\temp\\new.txt");
		
	}//main

}//class
