package day0110;

/**
 * ���ڿ�(String)�� ������ �� �ִ� class(java.lang.String)
 * @author user
 *
 */
public class UseString {

	public static void main(String[] args) {
		//�⺻�� ������ ���. str ��ü�� ���ڿ�������� �ּҸ� ���� ����
		String str = "ABCDE";
		
		//������ ���� ��� str2 ��ü�� heap �ּҸ� �����߰�, heap�ȿ��� ���ڿ� ������� �ּҸ� ����
		String str2 = new String("ABCDE");
		
		System.out.println(str);
		System.out.println(str2);
		
		System.out.println("�⺻��:"+ (str=="ABCDE")); //true
		System.out.println("������:"+ (str2=="ABCDE")); //false
		System.out.println(str == str2); //�������� str2�� ���� �ּҰ��� �������⋚����
		 								// str�� str2�� �ּҰ��� �ٸ����� false ���
		System.out.println(str.equals(str2));
		System.out.println(str.length());
		
	}

}
