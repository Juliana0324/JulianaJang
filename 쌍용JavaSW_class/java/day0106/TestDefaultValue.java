package day0106;


/**
 * 
 * class field�� ����Ǵ� ������ �ڵ��ʱ�ȭ�� �ȴ�
 * �����ڴ� �ʱⰪ�� ���� �ʿ����
 * @author user
 *
 */
public class TestDefaultValue {
	int i; //������ = 0;
	char c; //������ = \u0000(����)
	double d; //�Ǽ��� = 0.0
	boolean b; // false 
	
	TestDefaultValue tdv; //������ Null
	String str; //������ null
	int[] arr; //������ null
	
	public static void main(String[] args) {
		TestDefaultValue instance = new TestDefaultValue();
		System.out.println(instance.i);
		System.out.println(instance.c);
		System.out.println(instance.d);
		System.out.println(instance.b);
		System.out.println(instance.tdv);
		System.out.println(instance.str);
		System.out.println(instance.arr);
		
		
		
	}//main

}//class
