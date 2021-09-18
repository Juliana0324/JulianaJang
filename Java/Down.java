import java.util.List;
import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;

public class Down {

	public static void main(String[] args) {
		long n = 118372;
		String num = String.valueOf(n);
		String ansnum = "";
		
		char[] arr = new char[num.length()];
		for(int i=0; i<num.length();i++) {
			arr[i]+=num.charAt(i);
		}
		Arrays.sort(arr);
		
		char[] temp = new  char[num.length()];
		for(int i=0; i<num.length();i++) {
			temp[i]= arr[num.length()-i-1];
		}
		
		long answer = Long.parseLong(new String(temp));
		System.out.println(answer);
	
		
		//다른풀이
		/*
		String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String aList : list) sb.append(aList);

        return Long.parseLong(sb.reverse().toString());
        */
	}

}
