package day0104;

/**
 * Ư�� ������ ���
 * @author user
 *
 */
public class UseEscapeCharacter {

	public static void main(String[] args) {
		//�ȳ��ϼ��並 �ѹ� ����ϴ� �ڵ带 �ۼ�
		System.out.println("�ȳ��ϼ���?");
		System.out.println("'�ȳ��ϼ���?'");
		System.out.println("\"�ȳ��ϼ���?\"");
   
		//���� �ٷ� ���� \n
		System.out.println("���� �ٷ� \n�Ѿ��");
		

		// ��Ű ȿ�� = \t
		System.out.println("�ȳ�\t�ϼ���");
		
		// return Ŀ���� �������� ������ �̵�(�����츸 ����)= \r
		// Ư�����ڸ� ���ξ��� ���� ���������� TextArea
		// ���� enter key�� ������ \r\n�ڵ� 2���� �����
		System.out.println("\r�ȳ��ϼ���");

		// \"
		System.out.println("�ֵ���ǥ�� \"\" �̷��� ���ϴ� ");
		
		// \'  = �׳� �ᵵ ������
		System.out.println("Ȭ����ǥ \'\' �̷��� ���ϴ� ");

		// \b = backspace: ������½� ������ ����
		System.out.println("backspace\b");

		
		// \f = �������� ������ ����
		
		// \\ -> �������� ǥ�� : ex) �������� os ��� ǥ��
		System.out.println("\\");
		System.out.println("e:\\temp\\new.txt");
		
	}//main

}//class
