package day0210;

/**
 * runnable Interface를 구현한 클래스
 * @author user
 *
 */
//1. Runnable구현
public class UseRunnable implements Runnable{
	
	@Override
	public void run() {
		//동시에 실행되어야할 코드 Thread로 동작해야할 코드 정의
		for(int i=0; i<500; i++) {
			System.out.println("run ======>"+i);
		}
		
	}
	
	public void work() {
		for(int i=0; i<500; i++) {
			System.out.println("work --------->"+i);
		}
	}
	public static void main(String[] args) {
		//4.클래스를 객체화하고  
		UseRunnable ur = new UseRunnable();

		//5. thread클래스와 has a 관계설정. 
		Thread t= new Thread(ur);
		
		//6. Thread클래스의 start()호출
		t.start();
		
		ur.work();
	}//main
}
