package day0210;

/**
 * �����带 ������� ���
 * @author user
 *
 */
public class UseThread extends Thread{

	//2. runMethod�� override
	@Override
	public void run() {
		//3. ������� �����ؾ��� �ڵ带 ����(e���ý���);
		for(int i=0; i<500; i++) {
			System.out.println("run�� i ===>"+i);
		}
	}
	
	
	public static void main(String[] args) {
		UseThread ut= new UseThread();
		long st = System.currentTimeMillis();
		//start�� ȣ��
		//start�� ������ �ڵ尡 ���������� ��ӺҸ�
		ut.start();
		
		for(int i=0; i<500;i++) {
			System.out.println("main�� i===>"+i);
		}
		
		long et = System.currentTimeMillis();
		System.out.println("����ð�: "+(et-st)+"ms");
	}

}
