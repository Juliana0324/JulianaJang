package day0210;

/**
 * runnable Interface�� ������ Ŭ����
 * @author user
 *
 */
//1. Runnable����
public class UseRunnable implements Runnable{
	
	@Override
	public void run() {
		//���ÿ� ����Ǿ���� �ڵ� Thread�� �����ؾ��� �ڵ� ����
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
		//4.Ŭ������ ��üȭ�ϰ�  
		UseRunnable ur = new UseRunnable();

		//5. threadŬ������ has a ���輳��. 
		Thread t= new Thread(ur);
		
		//6. ThreadŬ������ start()ȣ��
		t.start();
		
		ur.work();
	}//main
}
