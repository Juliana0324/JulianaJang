package day0103;

/**
 * Switch~case 사용
 * 
 * @author user
 */
public class UseSwitchCase2 {
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	
	//학점 비교용 상수
	public static final int GRADE_A_PLUS =10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;
	
	
	public static void main(String[] args) {
		//입력값에 따라서 0-zero 1-one, 2- two출력
		
		int i=0;
		switch(i) { //case엔 변수사용x
		case ZERO:
			System.out.println("Zero");
			break;
		case ONE:
			System.out.println("One");
			break;
		case TWO:
			System.out.println("Two");
			break;
			
		default:System.out.println("others"); 
		//default문에서는 break문 생략가능
		
		}//end switch
////////////////////////////////////////////////////////////////////////////////////
		
		
		//입력값에 따라서 학점 출력코드
		//int score = Integer.parseInt(args[0]);
//		System.out.print(score+"점의 학점은 ");
		
//		char grade =' ';
//		switch(score/10) {
//		case GRADE_A_PLUS:
//		case GRADE_A: grade ='A';break;
//		case GRADE_B:grade ='B';break;
//		case GRADE_C:grade ='C';break;
//		case GRADE_D:grade ='D';break;		
//		default: grade ='F';		
//		}
		
//		char grade = 64;
//		switch(score/10) {
//			case GRADE_D: grade++; // 65
//			case GRADE_C: grade++; //66
//			case GRADE_B: grade++; //67
//			case GRADE_A: case GRADE_A_PLUS: grade++; /* 68 */ break;
//			default: grade+=6;
//		
//		}
//		
//		System.out.println(grade+"학점");
		
		//태어난 해를 입력받아 띠를 출력
		int year = Integer.parseInt(args[0]);
		String zodiac ="";
		switch(year%12) {// 0-원숭이, 1- 닭, 2-개, 3- 돼지, 4-쥐 5-소, 6-호랑이, 7-토끼, 8-용, 9-뱀, 10-말, 11-양
		case 0: zodiac="원숭이";break;
		case 1: zodiac="닭";break;
		case 2: zodiac="개";break;
		case 3: zodiac="돼지";break;
		case 4: zodiac="쥐";break;
		case 5: zodiac="소";break;
		case 6: zodiac="호랑이";break;
		case 7: zodiac="토끼";break;
		case 8: zodiac="용";break;
		case 9: zodiac="뱀";break;
		case 10: zodiac="말";break;
		default: zodiac="양";
		}
		System.out.println(zodiac+"띠 입니다.");
		
		
		
		
		

		
		
	}

}
