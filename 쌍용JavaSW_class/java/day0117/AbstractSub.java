package day0117;

/**
 * �߻�Ŭ������ �ڽ�Ŭ����
 * �θ�Ŭ������ �߻�޼ҵ带 �ݵ�� Overriding �ؾ���
 * @author user
 *
 */
public class AbstractSub extends AbstractSuper{
	
	int i;

//	@Override
//	public void methodA() {
//		System.out.println("�޼ҵ�A");
//	}
	
	@Override
	public void methodB() {
		System.out.println("���� �����ڴ� �޶󵵵ǰ�, ��ȯ��, method��, �Ű������� ���� ����");
	}

	@Override
	public int methodC(String name) {
		return name.length();
	}

	public static void main(String[] args) {
		AbstractSub as = new AbstractSub(); //super() �ڵ�����
		as.i = 0;
		as.methodA();
		as.methodB();
		System.out.println(as.methodC("Julie"));
		
		
		System.out.println("======================");
		//��Ӱ����� ��üȭ(�ڽ��� �θ��̴�. is a ����)
		//�ڽ�Ŭ���������� �θ�Ŭ������ ������ �˼� �ֱ� ������ 
		//�ڽ�Ŭ������ ��ü�� �θ�Ŭ������ ������� ��ü�� �Ҵ�ɼ� �ִ�
//		AbstractSub asub = new AbstractSuper(); ==> �θ�� �ڽ��� �𸣱⶧���� 
		AbstractSuper asuper = new AbstractSub(); //is a ������ ��üȭ
		//��ü�� �θ��� ������ ����ϱ� ������ �ڽ��� ��� ����� ����� �� x
		asuper.i =10;
		asuper.methodA();
		asuper.methodB(); //body�� ���� ���� �� �������� �ڽ��� override�� �߱� ������ �ֿ켱������ �Ҹ�
		
		System.out.println(asuper.methodC("���´�"));
		
		
		
	}
}
