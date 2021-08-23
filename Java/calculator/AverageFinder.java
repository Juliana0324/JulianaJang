package calculator;

public class AverageFinder {
	double computeAverage(int[] intArray) {
		double a=0;
		
		for(int i=0;i<intArray.length;i++) {
			a+=intArray[i];
		}
		a = a/intArray.length;
		
		return a;
		
	}
	
}
