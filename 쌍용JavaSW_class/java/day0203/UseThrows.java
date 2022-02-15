package day0203;

/**
 * throws�� ����� ���� ����,
 * ������, �Ϲ� method, main method�� ���� �� �ִ�
 * �����ڿ� throws���̸� ��üȭ(�ν��Ͻ�)�Ҷ� ó���մϴ�.
 * 
 * �Ϲ�method���� throws�� ���̸� ȣ���ϴ� ������ ���ܸ� ó���Ѵ�.
 * main�޼ҵ忡 throw�� ���̸� JVM�� ���ܸ� ó���Ѵ�
 * @author user
 *
 */
public class UseThrows {
	
	/**
	 * ȣ���� ������ �޼ҵ� �� �߻��� ���ܸ� ó���ϵ��� throws ����.
	 * @throws ClassNotFoundException
	 */
	public void work() throws ClassNotFoundException {
		Class.forName("java.lang.Integer1");
		System.out.println("Ŭ�����ε� ����");
	}
	
	public void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
	

	public static void main(String[] args){
		UseThrows us =  new UseThrows();
//		try {
//			us.work();
//			
//		}catch (ClassNotFoundException cnfe) {
//			System.err.println("Ŭ������ �������� �ʽ��ϴ�.");
//			cnfe.printStackTrace();
//		}
		
		try {
			for(int i=0; i<5; i++) {
				us.sleep();
				System.out.println(i);
			}
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}
}
