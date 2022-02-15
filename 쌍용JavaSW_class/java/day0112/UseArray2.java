package day0112;

/**
 * 이차원 배열([행][열])
 * 행의수 : 배열명.length
 * 열의 수: 배열명[행의번호].length
 * @author user
 *
 */
public class UseArray2 {
	
	public UseArray2() {
		
		//1.2차원 배열의 사용 및 선언
		int[][] arr = null;
		
		//2. 생성 배열명 = new 데이터형[행][열]
		arr = new int[5][6];
		
		System.out.println("행의 수: "+ arr.length);
		System.out.println("열의 수: "+ arr[0].length);
				
		//3. 값 할당
		// 배열명[행의 번호][열의 번호]= 값
		arr[0][0] = 2022;
		arr[3][2] = 12;
		
		//4. 배열명[행의번호][열의 번호]
		System.out.println(arr[0][0]);
		System.out.println(arr[3][2]);
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.printf("arr[%d][%d]=%-7d\t",i,j, arr[i][j]);
				
				}
			System.out.println();
			}//endfor
		
		System.out.println("---------------기본형 형식의 사용--------------------------");
		int[][] arr2 = {{10,20,30,40},{50,60,70,80},{90,100,110,120}};
		System.out.printf("%d행, %d열\n",arr2.length, arr2[0].length);
		
		arr2[0][2] = 3000;
		//일괄처리
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
