import java.util.Scanner;

public class CodeitProgram {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		while(true) {
			System.out.println("(I)ntro (C)ourses (E)xit");
			String text = sc.next();
			
			if(text.equals("I")||text.equals("i")) {
				System.out.println("�ȳ��ϼ���! �츮�� �ڵ����Դϴ�.\r\n" + 
						"�Բ� �����սô�!");
				continue;
			}
			else if(text.equals("C")||text.equals("c")) {
				System.out.println("�ڵ��� ������ �Ұ��մϴ�.");
				System.out.println("(P)ython (J)ava (i)OS (B)ack");
				String text2 = sc.next();
				if(text2.equals("P")||text2.equals("p")) {
					System.out.println("Python �� ���� ��ǻ�� ���̾��� ���ʸ� ���ϴ�.\r\n" + 
							"����: ������\r\n" + 
							"��õ ��������: ����");
				}
				else if(text2.equals("J")||text2.equals("j")) {
					System.out.println("Java�� �⺻ ������ ��ü������ ���α׷����� ���ϴ�.\r\n" + 
							"����: �����\r\n" + 
							"��õ ��������: Python");
				}
				else if(text2.equals("i")||text2.equals("I")) {
					System.out.println("�ֽ� Swift �� ���� iOS ������ ������ �� �ֽ��ϴ�.\r\n" + 
							"����: ����ȣ\r\n" + 
							"��õ ��������: Python, Java");
				}
				else if(text2.equals("b")||text2.equals("B")) {
					continue;
				}
			}

			
			if(text.equals("E")|| text.equals("e")) {
				System.out.println("�ȳ��� ������.");
				break;
				
			}
			
		}
		
	}

}
