package day0110;

/**
 * String-���ڿ� Ŭ�������� �����ϴ� method�� ���
 * @author user
 *
 */
public class UseStringMethod {

	public static void main(String[] args) {
		String str = "ABcDef"; //�⺻��
		String str2 = new String("chiang324@naver.com"); //������
				
		System.out.println("���ڼ�: "+ str.length());
		System.out.println("�빮��: "+ str.toUpperCase());
		System.out.println("�ҹ���: "+ str.toLowerCase());
		
		System.out.println("�빮��: "+ str2.toUpperCase());
		
		String[] arr = str2.split("@");
		for(String a : arr) {
			System.out.print(a+" ");			
		}
		System.out.println();
		System.out.println(str2.contains("@"));
		System.out.println(str2.matches("chiang324@naver.com"));
		
		
		str = "AbcdEfbcd";
		System.out.println("�տ������� �ε�����: "+str.indexOf("c")); //2 - �ε��� ��
		System.out.println("�տ������� �ε�����: "+str.indexOf("Efb")); //4 - �Ǿ��� �ε��� ��
		System.out.println("�ε�����: "+str.indexOf("a")); //-1 - �ε��� ��
		System.out.println("�ڿ��������� �ε��� �� "+str.lastIndexOf("c")); //7
		System.out.println("�ڿ��������� �ε��� �� "+str.lastIndexOf("bcd")); //7
		System.out.println(str.charAt(2)); //�������� ������ ����
		System.out.println();
		
		
	}

}
