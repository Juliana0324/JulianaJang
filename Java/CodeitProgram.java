import java.util.Scanner;

public class CodeitProgram {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		while(true) {
			System.out.println("(I)ntro (C)ourses (E)xit");
			String text = sc.next();
			
			if(text.equals("I")||text.equals("i")) {
				System.out.println("안녕하세요! 우리는 코드잇입니다.\r\n" + 
						"함께 공부합시다!");
				continue;
			}
			else if(text.equals("C")||text.equals("c")) {
				System.out.println("코드잇 수업을 소개합니다.");
				System.out.println("(P)ython (J)ava (i)OS (B)ack");
				String text2 = sc.next();
				if(text2.equals("P")||text2.equals("p")) {
					System.out.println("Python 언어를 통해 컴퓨터 사이언스의 기초를 배웁니다.\r\n" + 
							"강사: 강영훈\r\n" + 
							"추천 선수과목: 없음");
				}
				else if(text2.equals("J")||text2.equals("j")) {
					System.out.println("Java의 기본 문법과 객체지향적 프로그래밍을 배웁니다.\r\n" + 
							"강사: 김신의\r\n" + 
							"추천 선수과목: Python");
				}
				else if(text2.equals("i")||text2.equals("I")) {
					System.out.println("최신 Swift 언어를 통해 iOS 개발을 시작할 수 있습니다.\r\n" + 
							"강사: 성태호\r\n" + 
							"추천 선수과목: Python, Java");
				}
				else if(text2.equals("b")||text2.equals("B")) {
					continue;
				}
			}

			
			if(text.equals("E")|| text.equals("e")) {
				System.out.println("안녕히 가세요.");
				break;
				
			}
			
		}
		
	}

}
