package day0106;

/**
 * 
 * Static Method:�ν��Ͻ� ������ ������� �ʰ� �Էµ� �����θ� ���� ó���� �Ҷ� static�޼ҵ� ���
 * public static void Test
 * 
 * 
 *
 */
public class UseStaticMethod {
	public static void Test() {
		System.out.println("Test �����޼ҵ� ȣ���");
		
	}
	public int intToChar(char n) {
		return n;
	}
	
	public static void main(String[] args) {
		//static �θ����� .���� ȣ��
		UseStaticMethod.Test();
		
		//�޼ҵ� ȣ��
		UseStaticMethod usm = new UseStaticMethod();
		System.out.println(usm.intToChar('A'));;
		
	}

}
