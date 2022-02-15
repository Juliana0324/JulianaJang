package day0113;

public class UseArray2 {
	public UseArray2() {
		int[][] arr = new int[6][7];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				if(i==0 || i==arr.length-1 || j==0 || j==arr[i].length-1) {
					arr[i][j]=1;
				}
				System.out.printf("%-3d",arr[i][j]);
				
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {
		new UseArray2();
	}

}
