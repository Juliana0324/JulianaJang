package day0103;

/**
 * Switch~case ���
 * 
 * @author user
 */
public class UseSwitchCase2 {
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	
	//���� �񱳿� ���
	public static final int GRADE_A_PLUS =10;
	public static final int GRADE_A=9;
	public static final int GRADE_B=8;
	public static final int GRADE_C=7;
	public static final int GRADE_D=6;
	
	
	public static void main(String[] args) {
		//�Է°��� ���� 0-zero 1-one, 2- two���
		
		int i=0;
		switch(i) { //case�� �������x
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
		//default�������� break�� ��������
		
		}//end switch
////////////////////////////////////////////////////////////////////////////////////
		
		
		//�Է°��� ���� ���� ����ڵ�
		//int score = Integer.parseInt(args[0]);
//		System.out.print(score+"���� ������ ");
		
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
//		System.out.println(grade+"����");
		
		//�¾ �ظ� �Է¹޾� �츦 ���
		int year = Integer.parseInt(args[0]);
		String zodiac ="";
		switch(year%12) {// 0-������, 1- ��, 2-��, 3- ����, 4-�� 5-��, 6-ȣ����, 7-�䳢, 8-��, 9-��, 10-��, 11-��
		case 0: zodiac="������";break;
		case 1: zodiac="��";break;
		case 2: zodiac="��";break;
		case 3: zodiac="����";break;
		case 4: zodiac="��";break;
		case 5: zodiac="��";break;
		case 6: zodiac="ȣ����";break;
		case 7: zodiac="�䳢";break;
		case 8: zodiac="��";break;
		case 9: zodiac="��";break;
		case 10: zodiac="��";break;
		default: zodiac="��";
		}
		System.out.println(zodiac+"�� �Դϴ�.");
		
		
		
		
		

		
		
	}

}
