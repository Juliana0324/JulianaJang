package day0211;

import java.util.Calendar;

public class UseLamda {

	
	public static void main(String[] args) {
		Test t =()->{System.out.println("이것이 람다다");};
		t.method();
		
		Test2 t2 =(int age, String name)->{System.out.println(age+"살, "+name);};
		t2.method(20, "또리누나");
		
		System.out.println("=======================반환형이 있고 return값 있음===================");
		//리턴값이 있는것
		Test3 t3 =(int age)->{
			Calendar cal = Calendar.getInstance();
			int birth = cal.get(Calendar.YEAR)-age+1;
			return "태어난해 : "+birth;};

		int age =25;
		String value = t3.method(age);
		System.out.println(age+"의 태어난 해"+value);
		System.out.println("==================스레드===========================");
		
		Thread thread = new Thread(() -> {
			for(int i=1; i<100; i++) {
				System.out.print(i+" ");
			}
		});
		
		thread.run();
		System.out.println();

		
	
	}//main

}
