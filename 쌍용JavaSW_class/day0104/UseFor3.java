package day0104;

/**
 * for(�ʱⰪ; ���ǹ�; �����Ұ�){
 * 	���๮��
 * }
 * @author user
 */
public class UseFor3 {
	public static void main(String[] args) {
		/*
		 * for(;;) { System.out.println("���ѷ���"); break; //�ѹ� �����ϰ� ���� -> ���� ����� �ݺ����� ��������
		 * }
		 */
		
		//�����ϴ� ���� ���� ���ѷ���
		/*
		 * for(int i=0; ;i++) { System.out.println("���ѷ��� = "+i); //���� ���� }
		 *///		System.out.println("�ȳ�"); //������� �������� ����

		
		//�߰� ���ǹ��� �Ѱ��� �ۼ� ����
		// => i<10 , j>100 .. �̷������� ���Ұ�
		for(int i=0,j=10,k=1; i<10; i++,j--,k+=k) {
			System.out.println("i = "+i+", j = "+j+ ", k = "+k);
		}
		
		/* ���
			i = 0, j = 10, k = 100
			i = 1, j = 9, k = 101
			i = 2, j = 8, k = 102
			i = 3, j = 7, k = 103
			i = 4, j = 6, k = 104
			i = 5, j = 5, k = 105
			i = 6, j = 4, k = 106
			i = 7, j = 3, k = 107
			i = 8, j = 2, k = 108
			i = 9, j = 1, k = 109

		 */
		
		
		//improvement for() - for each��
		int[] arr = {1,2,3,4,5};
		for(int i: arr) {
			System.out.println(i);
		}
		//������ index�� ����ϴ� for�ʹ� �ٸ��� collection�� 
		//���� ��� ���� �ڵ�� ����ϱ� ���� ���
		
		
	}//main

}//class
