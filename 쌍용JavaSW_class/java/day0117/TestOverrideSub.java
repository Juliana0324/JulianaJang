package day0117;

/**
 * �ڽ�Ŭ����
 * �θ�Ŭ���� ���
 * �������̵��� ����: 
 * �θ�Ŭ������ �����ϴ� ����� �ڽ�Ŭ�������� ���� ������ �ڽ�Ŭ������ �ʿ��� ����� ������ �ϴ°�
 * 
 * ��Ģ:
 * ��ȯ��, method��, �Ű������� ������
 * @author user
 *
 */
public class TestOverrideSub extends TestOverrideSuper{

	
	@Override
	public void temp() {
		System.out.println("�ڽ�Ŭ������ temp method");
	}
	
	public void sub() {
		System.out.println("�ڽ�Ŭ������ ���� method");
	}
	
	public String toString() {
		return "toString �޼ҵ�";
	}
	
	
}
