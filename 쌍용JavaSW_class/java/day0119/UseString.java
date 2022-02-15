package day0119;

/**
 * String, 
 * StringBuffer(JDK1.0����) - �������ٺҰ�(����ȭ), 
 * StringBuilder(JDK 1.5����) - �������ٰ���(����ȭx) 
 * �ӵ�: Builder > Buffer
 * @author user
 *
 */
public class UseString {

	public static void main(String[] args) {
		String str = "�ȳ�";
		str += "�ϼ���? ";
		
		System.out.println(str + "������ ������ "+"�����Դϴ�");
		
	/*	class���� ���̴� ���
	 
	String str = "\uC548\uB155";
    str = (new StringBuilder(String.valueOf(str))).append("\uD558\uC138\uC694? ").toString();
    System.out.println((new StringBuilder(String.valueOf(str))).append("\uB208\uC624\uB294 \uC218\uC694\uC77C ").append("\uC624\uC804\uC785\uB2C8\uB2E4").toString());
   
   */
		
		//������
		//StringBuilder, StringBuffer => ���� �Ǽ� ���� ���ڿ� �Ҹ��� �߰��Ҽ� ����
		StringBuilder sb =new StringBuilder();
		sb.append(19).append("th. Hi");
		System.out.println(sb);
		
		System.out.println(sb.length());
		String str1 = sb.toString(); //String������ ���� => StringBuilder���� UpperCase�� LowerCase�� ����
		System.out.println(str1.toUpperCase());

		sb.insert(0, "Today is ");
		System.out.println(sb);
		
		sb.delete(0, 5);
		System.out.println(sb);
		
		
		System.out.println("----------------split�޼ҵ�--------------------------");
		//StringTokener��  ����� String method
		//split�� �迭��
		String csvData = "Java, Oracle, Jdbc, Html";
		String[] arr = csvData.split(", ");
		for(String lang:arr) {
			System.out.println(lang);
		}

	}
}
