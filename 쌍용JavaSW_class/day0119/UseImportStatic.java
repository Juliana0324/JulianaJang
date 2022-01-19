package day0119;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;


public class UseImportStatic {

	public static void main(String[] args) {
		System.out.println("Int의 최고값: "+ MAX_VALUE);
		
		byte b= 10;
		int i= 20;
		double d= 2022.01;
		
	
		String bs = String.valueOf(b);
		String is = String.valueOf(i);
		String ds = String.valueOf(d);
		
		
		int sb = parseInt(bs);
		int si = parseInt(is);
		int sd = (int)Double.parseDouble(ds);

		System.out.print(sb+" / "+si+" / "+sd);

		
		
		
		
	}

}
