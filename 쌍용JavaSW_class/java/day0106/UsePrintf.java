package day0106;

import java.time.LocalDate;

/**
 * VA�� �����Ͽ� �ۼ��� �޼ҵ� ���
 * printf �����
 * @author user
 *
 */
public class UsePrintf {

	public static void main(String[] args) {
		int i=2022;
		char a= 'A';
		double d = 202.231953;
		String s ="����";
		
		System.out.printf("���� : i�� ���� %d�Դϴ�\n",i);
		System.out.printf("������� �ڸ���: [%8d]\n",i);
		System.out.printf("������� �ڸ���: [%-8d]\n",i);

		
		System.out.printf("���� : %c\n",a);
		System.out.printf("���� ��� �ڸ���: [%5c]\n",a);
		System.out.printf("���� ��� �ڸ���: [%-5c]\n",a);

		System.out.printf("�Ǽ� : %8.3f\n",d);
		System.out.printf("�Ǽ� : %-8.3f\n",d);
		System.out.printf("���ڿ� : %s\n",s);
		
		System.out.printf("%d %-4c %.2f\n",i,a,d);
		
		System.out.println();
		////////////////////////////////////////////////
		int year = 2022;
		int month =1;
		int day = 6;
		char week ='T';
		String msg = "������ ������Դϴ�";
		
		
		System.out.printf("������ %d�� %d�� %d�� %c���� ������ �޼���: %s\n",year, month,day,week,msg);
		System.out.format("������ %d�� %d�� %d�� %c���� ������ �޼���: %s\n",year, month,day,week,msg);
		System.out.println("������ "+year+"�� "+month+"�� "+day+"�� "+week+"���� ������ �޼���: "+msg);
		
		LocalDate currentTime = LocalDate.now();
		System.out.println(currentTime);
		
		
	}
	
	
}
