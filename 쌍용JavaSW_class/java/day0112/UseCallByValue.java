package day0112;

/**
 * �� ���� : method�� �Ű������� 
 * @author user
 *
 */
public class UseCallByValue {	
	/**
	 * �Ű������� ����� i�� j�� ���� ���� �ٲٴ���
	 * @param i
	 * @param j
	 */
	public void swap(int i,int j) {
		int temp =0 ;
		temp = i;
		i=j;
		j = temp;
		System.out.printf("swap method ��: i = %d, j=%d\n", i, j);
	}
	
	public static void main(String[] args) {
		UseCallByValue cbv = new UseCallByValue();
		int i=100, j=300;
		System.out.printf("swap ��: i = %d, j=%d\n", i, j); //100, 300
		cbv.swap(i, j);
		System.out.printf("swap ��: i = %d, j=%d\n", i, j); //100, 300
	}

}
