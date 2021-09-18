import java.util.Arrays;

public class StrangeWord {

	public static void main(String[] args) {
		String s = "try hello world";
		String[] arr = s.split("");
	
		int idx=0;
		for(int i=0;i<arr.length;i++) {
			
			//" " 띄어쓰기가 있으면 idx를 0으로 초기화
			if(arr[i].equals(" ")) {
				idx = 0;
			}
			else if(idx%2 ==0) {
				arr[i]= arr[i].toUpperCase();
				idx++;
			}
			else if(idx%2 !=0) {
				arr[i]=arr[i].toLowerCase();
				idx++;
			}
			System.out.println(arr[i]);
		}
		
		System.out.println(Arrays.toString(arr));

	}

}
