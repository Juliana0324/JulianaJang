package day0117;

/**
 * �������̽��� ������ Ŭ����
 * @author user
 *
 */
public class TestInterfaceImpl implements TestInterface {

	@Override
	public void test() {

		System.out.println("�������̵��� test�޼ҵ�");
	}

	@Override
	public String test(int i) {
		// TODO Auto-generated method stub
		return String.valueOf(i);
	}
	

	public static void main(String[] args) {
//		TestInterface ti = new TestInterface();
	
		//default�޼ҵ�� static �޼ҵ尡 �ƴϱ⶧���� ����ȣ��x
//		TestInterface.temp();
		
		
		TestInterfaceImpl tii =new TestInterfaceImpl();
		System.out.println(tii.temp()); //default method
		
		tii.test();
		System.out.println(tii.test(2022));
		
		System.out.println("===============================");
		//is a ������ ��üȭ
		TestInterface ti = new TestInterfaceImpl();
		System.out.println(ti.temp());
		tii.test();
		System.out.println(tii.test(2022));
		
	}

}
