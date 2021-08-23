package arrayPractic;

import java.util.Arrays;

public class GreatestDifferenceFinder {
    int greatestDifference(int[] intArray) {
    	int a=0;
    	if (intArray.length<2){
    			return a;
	}
    	
    	Arrays.sort(intArray);
    	a= intArray[intArray.length-1]-intArray[0];
    	
    	return a;

    }
}
