package day0210;

public class UseSleep implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		UseSleep us = new UseSleep();
		Thread t = new Thread(us);
		t.start();
	}

	@Override
	public void run() {
		try {
			for(int i=0; i<10; i++) {
			System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
