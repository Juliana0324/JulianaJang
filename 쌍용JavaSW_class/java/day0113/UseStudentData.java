package day0113;

/**
 * int,String,int, String, double�ε� ����� ���� �ڷ���
 * @author user
 *
 */
public class UseStudentData{

	public static void main(String[] args) {
		StudentData jeongwoo = new StudentData(1, "������", 25, "A", 161.9);
		StudentData jaewon= new StudentData(2, "�����", 25, "B", 185.5);
		
		
		System.out.printf("%s�л��� %d���̰� %d�� �������� %s���Դϴ�.\n", jeongwoo.getName(), jeongwoo.getNum(), jeongwoo.getAge(), jeongwoo.getBloodType());
		System.out.printf("%s�л��� %d���̰� %d�� �������� %s���Դϴ�.\n", jaewon.getName(), jaewon.getNum(), jaewon.getAge(), jaewon.getBloodType());
		
		jeongwoo.setAge(jeongwoo.getAge()+1);
		jaewon.setAge(jaewon.getAge()+1);
		System.out.printf("%s�л��� %d���̰� %d�� �������� %s���Դϴ�.\n", jeongwoo.getName(), jeongwoo.getNum(), jeongwoo.getAge(), jeongwoo.getBloodType());
		System.out.printf("%s�л��� %d���̰� %d�� �������� %s���Դϴ�.\n", jaewon.getName(), jaewon.getNum(), jaewon.getAge(), jaewon.getBloodType());

		
		System.out.println("--------------------------------------------------------------------------");
		//��ü �迭
		// ���� + ����
		StudentData[] studentArr = new StudentData[3];
		
		studentArr[0] = new StudentData(1, "������", 24, "A", 162.1);
		studentArr[1] = new StudentData(2, "������", 26, "AB", 185.5);
		studentArr[2] = new StudentData(3, "������", 26, "O", 177.5);
		
		StudentData jww= studentArr[0];
//		System.out.println(jww.toString());
		
		StudentData tmp = null;
		for(int i=0; i<studentArr.length; i++) {
			tmp = studentArr[i];
			System.out.println(tmp.getName()+" / "+tmp.getAge());
		}
		
		
		for(StudentData i: studentArr) {
			System.out.printf("�̸�: %s, ����: %d, Ű: %.2f, �¾��: %d\n",i.getName(), i.getAge(), i.getHeight(), (2021-i.getAge()+1));
		}
		
	}


}
