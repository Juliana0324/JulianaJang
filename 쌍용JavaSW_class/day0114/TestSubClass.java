package day0114;

/**
 * �ڽ�Ŭ����
 * @author user
 *
 */
public class TestSubClass extends TestSuperClass{
	
	int c;
	
	public TestSubClass() {
		System.out.println("�ڽ�Ŭ���� ������");
	}
	
	public void parentResource() {
		//����� Ư¡: �θ�Ŭ������ �ڿ��� �ڽ�Ŭ�������� �ڽ��� ��ó�� ����� �� ����
		
		this.a = 10; //public
		this.b =20; // protected
		this.c= 30; //TestSub������ �ν��Ͻ� ����
		super.c = 40; // TestSuperŬ����
		
		System.out.printf("a: %d, b: %d, c: %d, super.c : %d", a,b,c, super.c);
	}
	
}
