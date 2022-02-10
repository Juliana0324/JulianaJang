package day0210;


public class Homework0210 implements Runnable{
	
	@Override
	public void run() {
		int sec=0;
		System.out.print("loading");
		for(int i=0; i<20; i++) {
			sec = (int)(Math.random()*900);
			System.out.print(".");
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("finish");
	}
	
	public static void main(String[] args) {
		Homework0210 hw = new Homework0210();
		Thread t = new Thread(hw);
		t.start();
	}

	
}
