package day0105;

/**
 * do while���
 * �ּ� 1�� ����, �ִ����Ǳ��� ����
 * 
 *   */
public class UseDoWhile {

	public static void main(String[] args) {
		int i=1000; //�ʱⰪ
		//������ 1������
		do {
			System.out.println(i);
			i++;
		} while(i<10);
		////////////////////////////
		int j=2;
		i=Integer.parseInt(args[0]);
		do {
			if(i<10) {
				System.out.print(i+" * "+j +" = "+i*j+"\t");
				j++;				
			}else {
				System.out.println("2-10�� �̳� �Է�");
				break;
			}
		}while(j<10);
		
		
		
	}

}
