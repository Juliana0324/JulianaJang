package day0113;

public class UseStudents {

	public static void main(String[] args) {
		Students[] students = new Students[4];

		students[0] = new Students("������", 89, 88, 91);
		students[1] = new Students("������", 90, 76, 82);
		students[2] = new Students("������", 77, 77, 76);
		students[3] = new Students("Ȳ����", 100, 94, 97);
		
		//2.
		for(Students stu: students) {
			System.out.printf("%s, %d, %d, %d\n",stu.getName(), stu.getJava(), stu.getOracle(), stu.getHtml());
		}
		
		System.out.println();
		
		
		
		//4.
		System.out.print("�̸�\tJave\tOracle\tHtml\t ����\t ���\n");
		for(Students stu: students) {
			System.out.printf("%s\t %d\t %d\t %d\t %d\t %.2f\n",stu.getName(), stu.getJava(), stu.getOracle(), stu.getHtml(), stu.getTotalScore(), stu.getAvg());
		}
		
		System.out.println();
		
		//5.
		String lastName;
		int javaTotal=0, cnt=0;
		
		for(Students stu:students) {
			lastName =stu.getName().substring(0,1);
			if(lastName.equals("��")) {
				cnt++;
				javaTotal+=stu.getJava();
			}
			
		}
		System.out.printf("�达�� �л����� ����: %d ���: %.2f", javaTotal, (double)(javaTotal/cnt));
		
		
	}

}
