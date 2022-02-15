package day0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UseKeyboardInput {
	public UseKeyboardInput() throws IOException {
//		int val = System.in.read();
//		System.out.println("ÀÔ·Â°ª "+ val);
		
//		int vale = 0;
//		while(true) {
//			vale= System.in.read();
//			System.out.println(vale);
//		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String value = br.readLine();
		System.out.println(value);
		
	}
	public static void main(String[] args) {
		try {
			new UseKeyboardInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
