package day0104;

/**
 * ���� for��
 * for(�ʱⰪ: ���ǽ�; �����ҽ�){ <br>
 * 	for(�ʱⰪ: ���ǽ�; �����ҽ�){ <br>
 * 		�ݺ� ���� ����<br>
 * 	}<br>
 * }
 * 
 * @author user
 */
public class UseFor2 {
	public static void main(String[] args) {
		
		// ��°��:
		 /* 0 0
			0 1
			0 2
			1 0
			1 1
			1 2
		for(int i=0; i<2;i++) {
			for(int j=0; j<3; j++) {
				System.out.println(i +" "+ j);
			}//end for
		}//end for
		
		System.out.println();

		  */
		for(int i=0; i<5;i++) {
			for(int j=0; j<6; j++) {
				System.out.println("i = "+ i +", j = "+ j);
			}//end for
			System.out.println("---------------------");
		}//end for
		
		System.out.println();
		
		/////////////////////////////////////////////////
		// ������ (2�� -9��, �� �ܿ��� 1���� 9���� �ݺ�)
		// ������ ����
		for(int i=2; i<10;i++) {
			System.out.print(i+"��: ");
			for(int j=1;j<10; j++) {
				System.out.print(i+" * "+j+" = "+i*j+"\t");
			}//end for
			System.out.println();
		}//end for
		System.out.println("----------------------------------------");
		
		
		//���� ����
		for(int i=1; i<10;i++) {
			for(int j=2;j<10; j++) {
				System.out.print(j+" * "+i+" = "+i*j+"\t");
			}//end for
			System.out.println();
		}//end for
		System.out.println("----------------------------------------");
		
		///////////////////////////////////////////////////////////
		/* ��°��: 
		 *  0 1 0 2 0 3 0 4 
			1 2 1 3 1 4 
			2 3 2 4 
			3 4 
		 */
		for(int i=0; i<5; i++) {
			for(int j=1+i; j<5; j++) {
				System.out.print(i+" "+j+" ");
			}
			System.out.println();
		}
		System.out.println("----------------------------------------");
		
		
		/////////////////////////////////////////////////////////////////
		/*0 0
		  1 0 1 1
		  2 0 2 1 2 2
		  3 0 3 1 3 2 3 3 
		*/
		for(int i=0; i<4; i++) {
			for(int j=0; j<=i; j++) {
				System.out.print(i+" " +j+ " ");
			}
			System.out.println();
		}
		
		/////////////////////////////////////////////////////////////////
		//���� ����(while):
		// - �ڵ尡 ����Ǹ� ������� �ʾƾ��Ҷ��� ����
		// ���α׷� => �ð�, OS, ���� 
		
		
		
		
		
		
		
	}//main

}//class
