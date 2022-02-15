package day0203;

/**
 * compile exception: 
 * �ڵ��ÿ� �߻��ϴ� ����(byte�ڵ尡 ����� ��������� �ʴ� ���� ����)
 * @author user
 */
public class UseCompileException {
	
	public UseCompileException() {
		//new�� ������� �ʰ� �ܺ�Ŭ������ ��ü�� �����Ҷ�
		try {
//			Class obj= Class.forName("java.lang.String");
			Class obj= Class.forName("day0203.UseRuntimeException1");
			System.out.println(obj);
		} catch (ClassNotFoundException cnfe) {
			System.err.println("class�� �̸��� Ȯ���ϼ���");
			String msg = cnfe.getMessage();
			System.err.println("������ �޼���: "+msg);
			
			String msg1 = cnfe.toString();
			System.err.println("����ó�� ��ü�� ������ �޼���: "+msg1);
			cnfe.printStackTrace();
			System.out.println("===========================================");
		}
		
	}
	
	public static void main(String[] args) {
		new UseCompileException();
	}
}
