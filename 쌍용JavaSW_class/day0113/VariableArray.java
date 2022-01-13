package day0113;

/**
 * 가변배열
 * @author user
 *
 */
public class VariableArray {
	
	public VariableArray() {
		//1. 선언) 데이터형[][] 배열형= null
		
		//2. 배열형 = *new 데이터형[행의수][] ==> 열의 수를 설정하지 x 
		int arr[][] = new int[5][];
		
		//3. 배열 초기화
		arr[0] = new int[4];
		arr[1] = new int[2];
		arr[2] = new int[1];
		
		//초기값을 줄때에는 값을 넣어주지x  
		//arr[3] = new String[5]{1,2,3,4,5}; <== error
		arr[3] = new int[] {1,2,3,4,5};
		arr[4] = new int[] {10,20,30};
		
		//4. 값할당
		arr[0][0] =100;
		arr[1][1] = 200;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		for(int[] i: arr) {
			for(int j: i) {
				System.out.print(j+"\t");
			}
			System.out.println();
		}
		
		
			System.out.println();
			System.out.println("------------------------------");
			
			
		int[][] arr1 = {
				{ 1, 2, 3 },
				{ 4, 5 },
				{ 6,7,8,9 }
				};
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		new VariableArray();
		int[][] arr = {{10,20},{40,50,6,7}};
		int[] tmp = arr[0];
		
		for(int i:tmp) {
			System.out.print(i+" ");
		}
		
	}

}
