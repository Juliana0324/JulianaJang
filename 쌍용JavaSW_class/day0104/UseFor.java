package day0104;

/**
 * �ݺ��� (loopStatement)
 * ���۰� ���� �˶� ����ϴ� �ݺ��� for��
 * ���� for��
 * @author user
 */
public class UseFor {

	public static void main(String[] args) {

		for(int i=0; i<10;i++) {
			System.out.print("�ȳ��ϼ���?"+i);
		}
		System.out.println();
		////////////////////////////////////////////////////////////////
		
		
		// 1-10���� 1�� �����ϴ� �� ���ϱ�
		for(int i=1; i<=10;i++) {
			System.out.print(i+"\t");
		}//end for\
		System.out.println();
		
		/////////////////////////////////////////////
		
		//1-100���� ���߿� 2�ǹ�� ���
		for(int i=1; i<=100; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
				}
			}
		System.out.println();
		
		for(int i=1; i<=100; i++) {
			++i;
			System.out.print(i+" ");
		}
		System.out.println();
		
		///////////////////////////////////////////
		// 1�������� 100���� Ȧ���� ���
		for(int i=1; i<=100; i++) {
			i++;
			System.out.print(i+" ");
		}
		System.out.println();

		
		for(int i=1; i<100; i+=2) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//////////////////////////////////////////////////////
		//1�������� 9���� 1�� �����Ͽ� ����ϴ� �ڵ带 �ۼ�
		//���: ������ �Ʒ��� (��)
		for(int i=1; i<10; i++) {
			System.out.println("2 * "+ i+" = "+(2*i));
		}
		
		
		
		////////////////////////////////////////////////////////
		//1�������� 100������ ���� ���
		int sum =0;
		for(int i=1; i<101; i++) {
			sum +=i;
			
		}
		System.out.println(sum);
		
		//////////////////////////////////////////////////////
		// 10~1���� 1�� �����ϴ� �ݺ���
		for(int i=10; i>0; i--) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		//���ѹݺ��� ������ ctrl+alt+del
		
		
		
	}//main
}// class
