package day0112;

/**
 * ������ �迭([��][��])
 * ���Ǽ� : �迭��.length
 * ���� ��: �迭��[���ǹ�ȣ].length
 * @author user
 *
 */
public class UseArray2 {
	
	public UseArray2() {
		
		//1.2���� �迭�� ��� �� ����
		int[][] arr = null;
		
		//2. ���� �迭�� = new ��������[��][��]
		arr = new int[5][6];
		
		System.out.println("���� ��: "+ arr.length);
		System.out.println("���� ��: "+ arr[0].length);
				
		//3. �� �Ҵ�
		// �迭��[���� ��ȣ][���� ��ȣ]= ��
		arr[0][0] = 2022;
		arr[3][2] = 12;
		
		//4. �迭��[���ǹ�ȣ][���� ��ȣ]
		System.out.println(arr[0][0]);
		System.out.println(arr[3][2]);
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("arr[%d][%d]=%-7d\t",i,j, arr[i][j]);
				
				}
			System.out.println();
			}//endfor
		
		System.out.println("---------------�⺻�� ������ ���--------------------------");
		int[][] arr2 = {{10,20,30,40},{50,60,70,80},{90,100,110,120}};
		System.out.printf("%d��, %d��\n",arr2.length, arr2[0].length);
		
		arr2[0][2] = 3000;
		//�ϰ�ó��
		for(int i=0; i<arr2.length; i++) {
			for(int j=0;j<arr2[0].length; j++) {
				System.out.printf("arr2[%d][%d] = %d\t\t",i,j,arr2[i][j]);
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		
		for(int[] i:arr2) {
			for(int j: i) {
				System.out.print(j+"\t");
			}
			System.out.println("");
			
		}
		
		}//UseArray2

	
	
	
	public static void main(String[] args) {
		new UseArray2();
		System.out.println();
	
	}//main
	
}
