package day0304;

/**
 * �ܺο��� ��üȭ�ɼ� �����ϴ�.
 * @author user
 *1. Ŭ���� �ܺο��� ���� ��üȭ �Ҽ� ������Ѵ�
 *2. ��ü�� ��ȯ�ϴ� method����
 */
public class TestSingleton {
	private static TestSingleton ts;
	private TestSingleton() {
		
	}
	
	public static TestSingleton getInstance() {
		if(ts==null) {
			ts=new TestSingleton();
		}
		return ts;
	}
}
