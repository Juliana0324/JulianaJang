package day0113;

public class UseStudents {

	public static void main(String[] args) {
		Students[] students = new Students[4];

		students[0] = new Students("±èÁø¿µ", 89, 88, 91);
		students[1] = new Students("Á¤½ÃÇö", 90, 76, 82);
		students[2] = new Students("±èÇö¿ì", 77, 77, 76);
		students[3] = new Students("È²¼ºÁØ", 100, 94, 97);
		
		//2.
		for(Students stu: students) {
			System.out.printf("%s, %d, %d, %d\n",stu.getName(), stu.getJava(), stu.getOracle(), stu.getHtml());
		}
		
		System.out.println();
		
		
		
		//4.
		System.out.print("ÀÌ¸§\tJave\tOracle\tHtml\t ÃÑÁ¡\t Æò±Õ\n");
		for(Students stu: students) {
			System.out.printf("%s\t %d\t %d\t %d\t %d\t %.2f\n",stu.getName(), stu.getJava(), stu.getOracle(), stu.getHtml(), stu.getTotalScore(), stu.getAvg());
		}
		
		System.out.println();
		
		//5.
		String lastName;
		int javaTotal=0, cnt=0;
		
		for(Students stu:students) {
			lastName =stu.getName().substring(0,1);
			if(lastName.equals("±è")) {
				cnt++;
				javaTotal+=stu.getJava();
			}
			
		}
		System.out.printf("±è¾¾ÀÎ ÇĞ»ıµéÀÇ ÃÑÁ¡: %d Æò±Õ: %.2f", javaTotal, (double)(javaTotal/cnt));
		
		
	}

}
