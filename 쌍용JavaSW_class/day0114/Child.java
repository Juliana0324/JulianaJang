package day0114;

/**
 * parent�� �ڽ�Ŭ����
 * @author user
 *
 */
public class Child extends Parent{
	
	public Child() {
		super(20);
		System.out.println("child: �ڽ��� �⺻������");
	}
	
	public Child(int i) {		
		super();
		System.out.println("�ڽ��� �����ε��� ������ "+ i);
	}// child
	
}
