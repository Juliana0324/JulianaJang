package day0110;

import java.io.UnsupportedEncodingException;

/**
 * ���ڿ�(String)�� ������ �� �ִ� class(java.lang.String)
 * @author user
 *
 */
public class UseString {

	public static void main(String[] args){
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
		
		
		//1. str2���� ������ �ּҿ� ���� �ּҸ� �и�
		str2 = "chiang324@naver.com";
		String[] arr = str2.split("@");
		for(String i : arr) {
			System.out.println(i);
		}
		
		System.out.println("������ �ּ�: "+str2.substring(0,str2.indexOf("@")));
		System.out.println("���� �ּ�: "+str2.substring(str2.lastIndexOf("n")));
		
		//2. str2�� ���� �ּҸ� �����ڵ�� ��ȯ
		 for(int i=0; i<str2.length(); i++) {
			 System.out.print((int)str2.charAt(i)+" ");
		 }
		
		
		
	}

}
