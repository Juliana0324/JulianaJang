package day0210;

/**
 * 스레드를 상속으로 사용
 * @author user
 *
 */
public class UseThread extends Thread{

	//2. runMethod를 override
	@Override
	public void run() {
		//3. 쓰레드로 동작해야할 코드를 정의(e동시실행);
		for(int i=0; i<500; i++) {
			System.out.println("run의 i ===>"+i);
		}
	}
	
	
	public static void main(String[] args) {
		UseThread ut= new UseThread();
		long st = System.currentTimeMillis();
		//start를 호출
		//start를 눌르면 코드가 끝났음에도 계속불림
		ut.start();
		
		for(int i=0; i<500;i++) {
			System.out.println("main의 i===>"+i);
		}
		
		long et = System.currentTimeMillis();
		System.out.println("실행시간: "+(et-st)+"ms");
	}

}
