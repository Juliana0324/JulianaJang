package arrayPractic;

public class Main {

	public static void main(String[] args) {
		GreatestDifferenceFinder finder = new GreatestDifferenceFinder();

        // �׽�Ʈ 1
        int[] testArray1 = {-2, 7, 3};
        System.out.println(finder.greatestDifference(testArray1));

        // �׽�Ʈ 2
        int[] testArray2 = {8, 3, 14, 1};
        System.out.println(finder.greatestDifference(testArray2));

        // �׽�Ʈ 3
        int[] testArray3 = {4, 2, 3, 1};
        System.out.println(finder.greatestDifference(testArray3));

        // �׽�Ʈ 4
        int[] testArray4 = {};
        System.out.println(finder.greatestDifference(testArray4));

        // �׽�Ʈ 5
        int[] testArray5 = {1, 2, -3, 4, 5};
        System.out.println(finder.greatestDifference(testArray5));

        // �׽�Ʈ 6
        int[] testArray6 = {1};
        System.out.println(finder.greatestDifference(testArray6));
	}

}
