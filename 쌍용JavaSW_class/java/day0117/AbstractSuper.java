package day0117;

/**
 * ��üȭ�� ���� �ʴ� Ŭ����
 * @author user
 *
 */
public abstract class AbstractSuper {
	
	int i;
	public AbstractSuper() { //�ڽ�Ŭ���������� ȣ���
		System.out.println("�߻�Ŭ������ ������");
	}
	
	public void methodA() {
		System.out.println("�Ϲ� �޼ҵ�");
	}
	
	public abstract void methodB(); //�߻� �޼ҵ� => �ٵ� ����
	
	public abstract int methodC(String name); //�߻� �޼ҵ� => �ٵ� ����

	//	public static void main(String[] args) {
		//new AbstractSuper();

	
	//}//main
}
