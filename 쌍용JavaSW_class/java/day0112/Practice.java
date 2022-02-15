package day0112;

public class Practice {
	public static void main(String[] args) {
		int[][] arr = new int[6][7];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				if(i==0 || i==arr.length-1 || j==0 || j==arr[i].length-1) {
					System.out.print(1);
				}else {
					System.out.print(0);					
				}
					
			}
			System.out.println();
		}
		
	}
}
