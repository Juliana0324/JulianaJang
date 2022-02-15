package day0111;



/**
 * ���ڿ��� �ٷ�� String class��� <br>
 * 
 * ����: 1.java.lang ��Ű���� �����ϴ� Ŭ���� �̸����� Ŭ������ �����ϸ� ��Ű���� ������ 
 * 		���� �̸��� Ŭ������ ���� ���. (java.lang ��Ű���� Ŭ������ ����ϴ°��� �ƴϹǷ� error)
 * 		- import�� ����ص� ���� ����
 * 
 * �ذ� : 1. ���� �̸��� Ŭ������ �����ؾ߸� �Ѵٸ� �ڹٿ��� �����ϴ� Ŭ������ 
 * 		full path�� �ĺ��Ͽ� ���
 * 		full path: Ŭ������ ����Ҷ� ��Ű������ ��� ����Ͽ� ����ϴ� ����
 * 		
 *       2.java.lang ��Ű���� �����ϴ� Ŭ���� �̸����� Ŭ������ ������ x
 * 
 * @author user
 *
 */
public class UseString {
	
	public static void main(String[] args) {
		String str = "AbcdEfg"; //�⺻��
		String str2 = new String("abcde324@naver.com"); //������
		
		//str���� Abc���
		System.out.println(str.substring(0,3));
		System.out.println(str.substring(4));

		System.out.println("���� �ּ�: "+str2.substring(0,str2.indexOf("@")));
		System.out.println("������ �ּ�: "+str2.substring(str2.lastIndexOf("n")));
		
	
		
		str = "�����";
		System.out.println(str.startsWith("��"));
		System.out.println(str.endsWith("��"));
		System.out.println(str.endsWith("��"));
		str2 = "����� ������ ���ﵿ";
		System.out.println(str2.endsWith("��"));
		
		
		//���ڿ� ���� concat (���ڿ��� '+'�� ��������)
		str = "�ڹ�";
		String str3 = str.concat("SE");
		System.out.println(str3);
		System.out.println(str+"SE");
		
		//�յ� ����
		str = " Java SE ";
		System.out.println(str.trim());
		
		//���ڿ� ġȯ - replace
		//replaceAll(" ", "ġȯ�� ���ڿ�")
		System.out.println(str.replaceAll(" ", "!"));
		
		//replace�� replaceAll�� ����
		str = "abcdeababaaababababcddee";
		System.out.println(str.replace("abc", "�P"));
		System.out.println(str.replace("[abc]", "�P"));
		//String regex����ǥ����: [abc]=> a �Ǵ� b �Ǵ� c�� ����
		System.out.println(str.replaceAll("[abc]", "�P"));

		//�޼ҵ� ü��
		str="�ȳ��ڹ�"; 
		str2 = str.replaceAll("�ȳ�", "����").replaceAll("�ȳ�", "�߰�");
		System.out.println(str2+": �ι�° replaceAll(\"�ȳ�\",\"�߰�\")�� �ȳ��� ������ ����Ǿ� �ȵ���¡");
		
		//ģ���� ��ģ������ ���ֺ���
		str= "������ �Ǿ����̾�.�� ��";
		String filterTxt= str.replaceAll("��", "*").replaceAll("��", "*").replaceAll("��", "*").replaceAll("��", "*");
		System.out.println(filterTxt);
	
		//�⺻�� �������� ���� ���ڿ��� ����
		int i=11;
		double l = 2022.011;
		String s= Integer.toString(i);
		System.out.println(s);
		//static method�̱� ������ Ŭ������.valueOf�� ����
		System.out.println(String.valueOf(i));
		System.out.println(String.valueOf(l));
		
		// toString()�� ���� ��� Null PointerException(NPE)�� �߻���Ű���� 
		// valueOf�� "null"�̶�� ���ڿ��� ó���Ѵ�.
		

		//////////////////////////////////////////////////////////////////////////////////////		
		//String�� �ʱ�ȭ
		//1. null�� �ʱ�ȭ
		//2. empty
		String strNull = null; //������ �������� �ʱ�ȭ���� ���ٴ� ���̴�: �� �ּҸ� ������ �ʾҴٴ� ��
		String strEmpty = "";  //
		if(strNull == null) {
			System.out.println("���� �ּҸ� �������� �ʾҽ��ϴ�.");
		} 
		
		if(strEmpty == "") {
			System.out.println("���ڿ� ������� �ּҸ� �����Ͽ����ϴ�.");
		} 
	
		
		System.out.println(strEmpty.isEmpty()); //true
		//System.out.println(strNull.isEmpty()); //error :  Cannot invoke "String.isEmpty()" because "strNull" is null
		
		
	}//main
	
} //end UseString
