package day0211;

import java.util.Calendar;

public class UseLamda {

	
	public static void main(String[] args) {
		Test t =()->{System.out.println("�̰��� ���ٴ�");};
		t.method();
		
		Test2 t2 =(int age, String name)->{System.out.println(age+"��, "+name);};
		t2.method(20, "�Ǹ�����");
		
		System.out.println("=======================��ȯ���� �ְ� return�� ����===================");
		//���ϰ��� �ִ°�
		Test3 t3 =(int age)->{
			Calendar cal = Calendar.getInstance();
			int birth = cal.get(Calendar.YEAR)-age+1;
			return "�¾�� : "+birth;};

		int age =25;
		String value = t3.method(age);
		System.out.println(age+"�� �¾ ��"+value);
		System.out.println("==================������===========================");
		
		Thread thread = new Thread(() -> {
			for(int i=1; i<100; i++) {
				System.out.print(i+" ");
			}
		});
		
		thread.run();
		System.out.println();

		
	
	}//main

}
