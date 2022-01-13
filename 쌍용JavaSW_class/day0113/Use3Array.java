package day0113;

/**
 * 3차원 배열
 * 
 * @author user
 *
 */
public class Use3Array {
	
	public Use3Array() {
		//1. 선언) 데이터형[][][] 배열명 =null;		
		int[][][] arr1 = null;

		//2. 생성) 배열명 =new 데이터형[면][행][열];		
		arr1 = new int[3][3][4];
		System.out.println("면의 수: "+arr1.length+", 행의 수: "+ arr1[1].length+", 열의 수:"+arr1[0][0].length);
		
		//3. 값 할당
		arr1[0][0][0] = 2022;
		arr1[1][1][1] = 1;
		arr1[2][2][3] = 13;
		
		//4. 값사용
		System.out.println(arr1[0][0][0] + " / "+ arr1[1][1][1]+" / "+arr1[2][2][3]);

		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				for(int k =0; k<arr1[i][j].length; k++) {
					System.out.printf("arr1[%d][%d][%d] = %-5d", i,j,k, arr1[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
		System.out.println();
		
		int[][][] arr = {{{1,2,3},{4,5,6}},{{7,8,9},{10,11,12}}};
		for(int[][] i:arr) {
			for(int[] j:i) {
				for(int k: j) {
					System.out.print(k+"\t");
				}
				System.out.println();
			}
			System.out.println();
			
		}//end for
	}//Use3Array
	
	
	public static void main(String[] args) {
		new Use3Array();
		
	}//main

}//class
