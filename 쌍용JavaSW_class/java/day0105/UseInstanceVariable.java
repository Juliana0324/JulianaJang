package day0105;

/**
 * �ν��Ͻ� ����
 * 1. ����: ���������� �������� ������();
 * 2. ��ü ����: Ŭ������ ��ü�� = new Ŭ������();
 * 3. ��ü ������ ������ �� �Ҵ� : ��ü��.������ = ��;
 * @author user
 */
public class UseInstanceVariable {
 int i; //default ���������ڸ� ���� �ν��Ͻ�/�������
 
 public static void main(String[] args) {
//	 System.out.println(i); // �ν��Ͻ� ������ static �������� ��ü�� ���� �������x
	 //2. ��üȭ.int
	 //������ ��ü�� �����̸��� ���� i�� ����
	 UseInstanceVariable uiv = new UseInstanceVariable();
	 
	 //���Ҵ�.
	 uiv.i = 2022;
	 System.out.println(uiv.i);

	 UseInstanceVariable uiv1 = new UseInstanceVariable();
	 UseInstanceVariable uiv2 = new UseInstanceVariable();
	 uiv1.i = 1;
	 uiv2.i = 5;
	 System.out.println(uiv1.i);
	 System.out.println(uiv2.i);

	 
	 
 }

}
